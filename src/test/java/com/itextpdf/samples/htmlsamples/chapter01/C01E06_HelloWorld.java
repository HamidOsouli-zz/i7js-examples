/*
    This file is part of the iText (R) project.
    Copyright (c) 1998-2019 iText Group NV
    Authors: iText Software.

    For more information, please contact iText Software at this address:
    sales@itextpdf.com
 */
/*
 * This example was written in the context of the following book:
 * https://leanpub.com/itext7_pdfHTML
 * Go to http://developers.itextpdf.com for more info.
 */
package com.itextpdf.samples.htmlsamples.chapter01;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.licensekey.LicenseKey;

/**
 * Converts a simple HTML file to PDF using an InputStream and a PdfDocument
 * as arguments for the convertToPdf() method.
 */
public class C01E06_HelloWorld {

    /**
     * The path to the resulting PDF file.
     */
    public static final String DEST = "./target/htmlsamples/ch01/helloWorld06.pdf";

    /**
     * The Base URI of the HTML page.
     */
    public static final String BASEURI = "./src/test/resources/htmlsamples/html/";

    /**
     * The path to the source HTML file.
     */
    public static final String SRC = String.format("%shello.html", BASEURI);

    /**
     * The main method of this example.
     *
     * @param args no arguments are needed to run this example.
     * @throws IOException signals that an I/O exception has occurred.
     */
    public static void main(String[] args) throws IOException {
        LicenseKey.loadLicenseFile(System.getenv("ITEXT7_LICENSEKEY") + "/itextkey-html2pdf_typography.xml");
        File file = new File(DEST);
        file.getParentFile().mkdirs();

        new C01E06_HelloWorld().createPdf(BASEURI, SRC, DEST);
    }

    /**
     * Creates the PDF file.
     *
     * @param baseUri the base URI
     * @param src     the path to the source HTML file
     * @param dest    the path to the resulting PDF
     * @throws IOException signals that an I/O exception has occurred.
     */
    public void createPdf(String baseUri, String src, String dest) throws IOException { 
    	ConverterProperties properties = new ConverterProperties();
    	properties.setBaseUri(baseUri);
    	PdfWriter writer = new PdfWriter(dest);
    	PdfDocument pdf = new PdfDocument(writer);
    	pdf.setTagged();
    	HtmlConverter.convertToPdf(new FileInputStream(src), pdf, properties);
    }
}
