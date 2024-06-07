package org.capslv;

import com.spire.doc.*;
import com.spire.doc.documents.Borders;
import com.spire.doc.documents.StructureDocumentTagCell;

public class Main {
    public static void main(String[] args) {
        Document document =new Document();
        document.loadFromFile("doc/content.docx");
        Section section =document.getSections().get(0);
        Table table =section.getTables().get(0);
        TableRow tableRow = table.getFirstRow();
        TableCell tableCell =tableRow.getCells().get(0);

        StructureDocumentTagCell structureDocumentTagCell =new StructureDocumentTagCell(tableRow);

        for (int i = 0; i < tableCell.getChildObjects().getCount(); i++) {
            structureDocumentTagCell.getChildObjects().add(tableCell.getChildObjects().get(i).deepClone());
        }
        Borders borders = tableCell.getCellFormat().getBorders();
        structureDocumentTagCell.getCellFormat().getBorders().getLeft().setBorderType(borders.getLeft().getBorderType());
        structureDocumentTagCell.getCellFormat().getBorders().getLeft().setLineWidth(borders.getLeft().getLineWidth());

        structureDocumentTagCell.getCellFormat().getBorders().getRight().setBorderType(borders.getRight().getBorderType());
        structureDocumentTagCell.getCellFormat().getBorders().getRight().setLineWidth(borders.getRight().getLineWidth());

        structureDocumentTagCell.getCellFormat().getBorders().getTop().setBorderType(borders.getTop().getBorderType());
        structureDocumentTagCell.getCellFormat().getBorders().getTop().setLineWidth(borders.getTop().getLineWidth());

        structureDocumentTagCell.getCellFormat().getBorders().getBottom().setBorderType(borders.getBottom().getBorderType());
        structureDocumentTagCell.getCellFormat().getBorders().getBottom().setLineWidth(borders.getBottom().getLineWidth());


        tableRow.getChildObjects().insert(0,structureDocumentTagCell);
        tableRow.getChildObjects().removeAt(1);
        document.saveToFile("doc/1.docx", FileFormat.Auto);
    }
}