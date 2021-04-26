import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;

//import org.junit.Test;


public class MarathiPdfGenerationTest{


    private static final String MAR_TEXT = "शब्द\n\n";
    private static final String MAR_NAME = "नाव";
    private static final String MAR_NO = "क्रमांक";




    public void createPdf(String filename) throws DocumentException, IOException, SQLException {

        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream(filename));

        document.open();

        Paragraph paragraph = new Paragraph();
        paragraph.add(new Phrase(MAR_TEXT, new Font(BaseFont.createFont("src/main/resources/NotoSansDevanagari-Bold.ttf", BaseFont.IDENTITY_H, true))));
        document.add(paragraph);

        PdfPTable table = new PdfPTable(2);
        PdfPCell cell1 = new PdfPCell(new Phrase(MAR_NAME, new Font(BaseFont.createFont("src/main/resources/NotoSansDevanagari-Bold.ttf", BaseFont.IDENTITY_H, true))));
        PdfPCell cell2 = new PdfPCell(new Phrase(MAR_NO, new Font(BaseFont.createFont("src/main/resources/NotoSansDevanagari-Bold.ttf", BaseFont.IDENTITY_H, true))));
        table.addCell(cell1);
        table.addCell(cell2);

        // add further records
        table.addCell(new PdfPCell(new Phrase("Shaunak")));
        table.addCell(new PdfPCell(new Phrase("01")));


        document.add(table);
        document.close();
    }

    public static void main(String[] args) throws IOException, DocumentException, SQLException {
        String fileName = "fonttest.pdf";
        new MarathiPdfGenerationTest().createPdf(fileName);
        System.out.println("PDF Created.");
    }
}