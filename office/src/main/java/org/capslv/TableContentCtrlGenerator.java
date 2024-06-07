package org.capslv;

import com.spire.doc.*;
import com.spire.doc.documents.Borders;
import com.spire.doc.documents.StructureDocumentTagCell;
import com.spire.doc.documents.Paragraph;
import org.springframework.util.StringUtils;

public class TableContentCtrlGenerator {
    private final Document document;
    private final String filename;

    public TableContentCtrlGenerator(String filename) {
        this.filename = filename;
        this.document = new Document();
        this.document.loadFromFile(filename);
    }


    public void generate() {
        loadSections(this.document);
    }

    public void save(String filename) {
        this.document.saveToFile(filename, FileFormat.Auto);
    }

    private void loadSections(Document document) {
        for (int i = 0; i < document.getSections().getCount(); i++) {
            Section section = document.getSections().get(i);
            loadTables(section);
        }
    }

    private void loadTables(Section section) {
        for (int i = 0; i < section.getTables().getCount(); i++) {
            Table table = section.getTables().get(i);
            loadTable(table);
        }
    }

    private void loadTable(Table table) {
        for (int i = 0; i < table.getRows().getCount(); i++) {
             TableRow tableRow = table.getRows().get(i);
             loadTableRow(tableRow);
        }
    }

    private void loadTableRow(TableRow tableRow) {
        for (int i = 0; i < tableRow.getCells().getCount(); i++) {
            TableCell tableCell = tableRow.getCells().get(i);
            boolean text = getTextFromCell(tableCell);

            if (text) {
                setContentControl(tableRow, tableCell, i);
            }
        }
    }

    private void setContentControl(TableRow tableRow, TableCell tableCell, int i) {
        StructureDocumentTagCell structureDocumentTagCell = new StructureDocumentTagCell(tableRow);
        for (int j = 0; j < tableCell.getChildObjects().getCount(); j++) {
            structureDocumentTagCell.getChildObjects().add(tableCell.getChildObjects().get(j).deepClone());
        }
        Borders borders = tableCell.getCellFormat().getBorders();
        structureDocumentTagCell.getCellFormat().getBorders().getLeft().setBorderType(borders.getLeft().getBorderType());
        structureDocumentTagCell.setCellWidth(tableCell.getWidth(), tableCell.getCellWidthType());
        structureDocumentTagCell.getCellFormat().getBorders().getLeft().setLineWidth(borders.getLeft().getLineWidth());
        structureDocumentTagCell.getCellFormat().getBorders().getRight().setBorderType(borders.getRight().getBorderType());
        structureDocumentTagCell.getCellFormat().getBorders().getRight().setLineWidth(borders.getRight().getLineWidth());
        structureDocumentTagCell.getCellFormat().getBorders().getTop().setBorderType(borders.getTop().getBorderType());
        structureDocumentTagCell.getCellFormat().getBorders().getTop().setLineWidth(borders.getTop().getLineWidth());
        structureDocumentTagCell.getCellFormat().getBorders().getBottom().setBorderType(borders.getBottom().getBorderType());
        structureDocumentTagCell.getCellFormat().getBorders().getBottom().setLineWidth(borders.getBottom().getLineWidth());
        tableRow.getChildObjects().removeAt(i);
        tableRow.getChildObjects().insert(i, structureDocumentTagCell);
    }

    private boolean getTextFromCell(TableCell tableCell) {
        String text = "";
        for (int i = 0; i < tableCell.getParagraphs().getCount(); i++) {
            Paragraph paragraph = tableCell.getParagraphs().get(i);
            text += paragraph.getText();
        }
        return StringUtils.hasText(text);
    }

    public static void main(String[] args) {
        TableContentCtrlGenerator generator = new TableContentCtrlGenerator("doc/content.docx");
        generator.generate();
        generator.save("doc/1.docx");
    }
}
