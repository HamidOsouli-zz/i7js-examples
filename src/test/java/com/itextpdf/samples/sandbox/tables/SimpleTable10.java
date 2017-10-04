/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2017 iText Group NV
    Authors: iText Software.

    For more information, please contact iText Software at this address:
    sales@itextpdf.com
 */
/**
 * Example written by Bruno Lowagie in answer to the following question:
 * http://stackoverflow.com/questions/30267169/cannot-display-background-color-when-using-rowspan-with-itext-pdf
 */
package com.itextpdf.samples.sandbox.tables;

import com.itextpdf.kernel.color.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.samples.GenericTest;
import com.itextpdf.test.annotations.type.SampleTest;

import org.junit.experimental.categories.Category;

import java.io.File;

@Category(SampleTest.class)
public class SimpleTable10 extends GenericTest {
    public static final String DEST = "./target/test/resources/sandbox/tables/simple_table10.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SimpleTable10().manipulatePdf(DEST);
    }

    @Override
    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(dest));
        Document doc = new Document(pdfDoc);

        Table table = new Table(5);
        Cell sn = new Cell(2, 1).add("S/N");
        sn.setBackgroundColor(ColorConstants.YELLOW);
        table.addCell(sn);
        Cell name = new Cell(1, 3).add("Name");
        name.setBackgroundColor(ColorConstants.CYAN);
        table.addCell(name);
        Cell age = new Cell(2, 1).add("Age");
        age.setBackgroundColor(ColorConstants.GRAY);
        table.addCell(age);
        Cell surname = new Cell().add("SURNAME");
        surname.setBackgroundColor(ColorConstants.BLUE);
        table.addCell(surname);
        Cell firstname = new Cell().add("FIRST NAME");
        firstname.setBackgroundColor(ColorConstants.RED);
        table.addCell(firstname);
        Cell middlename = new Cell().add("MIDDLE NAME");
        middlename.setBackgroundColor(ColorConstants.GREEN);
        table.addCell(middlename);
        Cell f1 = new Cell().add("1");
        f1.setBackgroundColor(ColorConstants.PINK);
        table.addCell(f1);
        Cell f2 = new Cell().add("James");
        f2.setBackgroundColor(ColorConstants.MAGENTA);
        table.addCell(f2);
        Cell f3 = new Cell().add("Fish");
        f3.setBackgroundColor(ColorConstants.ORANGE);
        table.addCell(f3);
        Cell f4 = new Cell().add("Stone");
        f4.setBackgroundColor(ColorConstants.DARK_GRAY);
        table.addCell(f4);
        Cell f5 = new Cell().add("17");
        f5.setBackgroundColor(ColorConstants.LIGHT_GRAY);
        table.addCell(f5);
        doc.add(table);

        doc.close();
    }
}
