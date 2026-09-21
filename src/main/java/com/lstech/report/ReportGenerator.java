package com.lstech.report;

import org.openpdf.text.Document;
import org.openpdf.text.Element;
import org.openpdf.text.Font;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReportGenerator {

    private final List<ReportEntry> entries = new ArrayList<>();

    private final Font titleFont =
            new Font(Font.HELVETICA, 18, Font.BOLD);

    private final Font sectionFont =
            new Font(Font.HELVETICA, 13, Font.BOLD);

    private final Font normalFont =
            new Font(Font.HELVETICA, 10);

    public void registerStep(
            String step,
            String operation,
            String request,
            int statusCode,
            String response,
            boolean success) {

        entries.add(new ReportEntry(step, operation, request,
                        statusCode, response, success)
        );
    }

    public void generate(String filePath) {

        File file = new File(filePath);

        File parent = file.getParentFile();

        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }

        Document document = new Document(
                PageSize.A4,
                36,
                36,
                50,
                50
        );

        try {
            PdfWriter.getInstance(document, new FileOutputStream(file));

            document.open();
            addHeader(document);

            for (ReportEntry entry : entries) {
                addEntry(document, entry);
            }

            addFooter(document);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar relatório PDF",e);
        } finally {
            document.close();
        }
    }

    private void addHeader(Document document)
            throws Exception {

        Paragraph title = new Paragraph("SafeEntry API Test Report",titleFont);

        title.setAlignment(Element.ALIGN_CENTER);

        document.add(title);

        document.add(new Paragraph("Generated: "
                + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), normalFont)
        );

        document.add(new Paragraph(" "));
    }

    private void addEntry(Document document, ReportEntry entry) throws Exception {
        document.add(new Paragraph(entry.step(), sectionFont));
        document.add(new Paragraph("Operation: " + entry.operation(),normalFont));
        document.add(new Paragraph("Status Code: " + entry.statusCode(),normalFont));
        document.add(new Paragraph("Result: " + (entry.success() ? "PASSED" : "FAILED"),normalFont));
        document.add(new Paragraph("Request", sectionFont));

        addCodeBlock(document, entry.request());
        document.add(new Paragraph("Response", sectionFont));

        addCodeBlock(document, entry.response());
        document.add(new Paragraph(" "));
    }

    private void addCodeBlock(Document document, String content) throws Exception {
        PdfPTable table = new PdfPTable(1);
        table.setWidthPercentage(100);
        PdfPCell cell = new PdfPCell(new Paragraph(content == null ? "" : content, normalFont));

        cell.setPadding(8);
        table.addCell(cell);
        document.add(table);
        document.add(new Paragraph(" "));
    }

    private void addFooter(Document document) throws Exception {
        document.add(new Paragraph(
                "Generated automatically by SafeEntry API Test Automation",
                normalFont)
        );
    }
}
