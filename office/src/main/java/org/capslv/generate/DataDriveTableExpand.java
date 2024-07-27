package org.capslv.generate;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.util.List;

public class DataDriveTableExpand {
    public static void dataDriveTableGenerate(XWPFTable table, JsonNode json) {
        int len = table.getRows().size();
        for (int i = len - 1; i >= 0; i--) {
            if (checkRow(table.getRow(i))) {
                int res = expandTable(table, json, i);
                table.removeRow(i);

                if (res > 0) {
                    for (int j = 0; j < table.getRows().get(i).getTableCells().size(); j++) {
                        checkMerge(table, i, j, res);
                    }
                }
            }
        }
    }

    private static boolean checkRow(XWPFTableRow row) {
        boolean result = false;
        for (XWPFTableCell cell : row.getTableCells()) {
            if (cell.getCTTc().getTcPr().getVMerge() != null) {
                return false;
            }
            String text = cell.getText();
            if (text.startsWith("{{") && text.endsWith("}}")) {
                result = true;
            }
        }
        return result;
    }

    private static int expandTable(XWPFTable table, JsonNode jsonData, int idx) {
        XWPFTableRow baseRow = table.getRow(idx);
        XWPFTableRow headerRow = table.getRow(idx);
        String basePlaceholder = getBasePlaceholder(baseRow);

        if (basePlaceholder.isEmpty()) {
            throw new RuntimeException("wrong template file");
        }

        String parentPlaceholder = basePlaceholder.split("\\.")[0];
        JsonNode parentNode = jsonData.get(parentPlaceholder);

        int k = 0;
        for (JsonNode jsonNode : parentNode) {
            XWPFTableRow newRow = table.insertNewTableRow(idx + ++k);
            for (int i = 0; i < baseRow.getTableCells().size(); i++) {
                XWPFTableCell baseCell = baseRow.getCell(i);
                XWPFTableCell newCell = newRow.getCell(i);
                if (newCell == null) {
                    newCell = newRow.createCell();
                }
                if (newCell != null && baseCell != null) {
                    String placeholder = headerRow.getCell(i).getText();
                    if (checkText(placeholder)) {
                        placeholder = placeholder.replace("{{", "")
                                .replace("}}", "").split("\\.")[1];
                        String cellData = jsonNode.get(placeholder) == null ? ""
                                : jsonNode.get(placeholder).asText();
                        newCell.setText(cellData);
                    } else {
                        newCell.setText(baseCell.getText());
                    }
                    copyCellStyle(baseCell, newCell);
                }
            }
        }
        return k;
    }

    private static String getBasePlaceholder(XWPFTableRow row) {
        for (XWPFTableCell cell : row.getTableCells()) {
            String text = cell.getText();
            if (checkText(text)) {
                return text.substring(2, text.length() - 2);
            }
        }
        return "";
    }

    private static boolean checkText(String placeholder) {
        boolean valid = placeholder.startsWith("{{") && placeholder.endsWith("}}");
        if (!valid) {
            return false;
        }
        String text = placeholder.substring(2, placeholder.length() - 2);
        valid = text.split("\\.").length == 2;
        return valid;
    }

    public static void copyCellStyle(XWPFTableCell sourceCell, XWPFTableCell targetCell) {
        if (sourceCell.getCTTc().getTcPr() != null) {
            targetCell.getCTTc().setTcPr((CTTcPr) sourceCell.getCTTc().getTcPr().copy());
        }

        XWPFParagraph srcPara = sourceCell.getParagraphArray(0);
        CTP srcParaCTP = srcPara.getCTP();
        CTPPr srcParaStyle = srcParaCTP.getPPr();
        for (XWPFParagraph tgtPara : targetCell.getParagraphs()) {
            CTP tgtParaCTP = tgtPara.getCTP();
            tgtParaCTP.setPPr((CTPPr) srcParaStyle.copy());

            if (srcPara.getRuns() != null && !srcPara.getRuns().isEmpty()) {
                XWPFRun xwpfRun = srcPara.getRuns().get(0);
                for (int i = 0; i < tgtPara.getRuns().size(); i++) {
                    applyRunStyleFromRun(xwpfRun, tgtPara.getRuns().get(i));
                }
            } else {
                for (int i = 0; i < tgtPara.getRuns().size(); i++) {
                    applyRunStyleFromParagraph(srcPara, tgtPara.getRuns().get(i));
                }
            }
        }
    }

    private static void applyRunStyleFromRun(XWPFRun xwpfRun, XWPFRun targetRun) {
        targetRun.setFontFamily(xwpfRun.getFontFamily());
        targetRun.setFontSize(xwpfRun.getFontSizeAsDouble());
    }

    private static void applyRunStyleFromParagraph(XWPFParagraph sourceParagraph, XWPFRun targetRun) {
        CTPPr ctpPr = sourceParagraph.getCTPPr();
        if (ctpPr != null) {
            CTParaRPr ctrPr = ctpPr.getRPr();
            if (ctrPr != null) {
                List<CTFonts> rFontsList = ctrPr.getRFontsList();
                if (rFontsList != null && !rFontsList.isEmpty()) {
                    CTFonts ctFonts = rFontsList.get(0);
                    if (ctFonts != null) {
                        targetRun.setFontFamily(ctFonts.getAscii());
                    }
                }
            }
        }
    }

    private static void checkMerge(XWPFTable table, int row, int column, int k) {
        int startRow = row;
        int endRow = row;
        while (endRow < row + k) {
            String text = table.getRow(endRow).getCell(column).getText();
            if (text.isEmpty()) {
                startRow++;
                endRow = startRow;
            } else {
                int l = endRow + 1;
                for (; l < row + k; l++) {
                    String text2 = table.getRow(l).getCell(column).getText();
                    if (text2.isEmpty() || !text2.equals(text)) {
                        break;
                    }
                }
                endRow = l;
                if (endRow - startRow > 1) {
                    mergeCellsVertically(table, column, startRow, endRow == row + k ? endRow - 1 : endRow);
                }
                startRow = endRow;
            }
        }
    }

    private static void mergeCellsVertically(XWPFTable table, int colIndex, int startRow, int endRow) {
        for (int i = startRow; i <= endRow; i++) {
            XWPFTableCell cell = table.getRow(i).getCell(colIndex);

            if (i == startRow) {
                setCellMergeStart(cell);
            } else {
                setCellMergeContinue(cell);
            }
            setHorizontalAlignment(cell);
            setVerticalAlignment(cell);
        }
    }

    private static void setHorizontalAlignment(XWPFTableCell cell) {
        for (XWPFParagraph paragraph : cell.getParagraphs()) {
            paragraph.setAlignment(ParagraphAlignment.CENTER);
        }
    }

    private static void setVerticalAlignment(XWPFTableCell cell) {
        CTTc ctTc = cell.getCTTc();
        CTTcPr tcPr = ctTc.addNewTcPr();
        tcPr.addNewVAlign().setVal(STVerticalJc.CENTER);
    }

    private static void setCellMergeStart(XWPFTableCell cell) {
        CTTcPr cellProperties = cell.getCTTc().addNewTcPr();
        cellProperties.addNewVMerge().setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge.RESTART);
    }

    private static void setCellMergeContinue(XWPFTableCell cell) {
        CTTcPr cellProperties = cell.getCTTc().addNewTcPr();
        cellProperties.addNewVMerge().setVal(org.openxmlformats.schemas.wordprocessingml.x2006.main.STMerge.CONTINUE);
    }
}
