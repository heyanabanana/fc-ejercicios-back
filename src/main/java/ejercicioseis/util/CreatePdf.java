package ejercicioseis.util;

import ejercicioseis.models.Candidate;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatePdf {

    public static void createPDF(String nombre, Candidate candidate) {

        try {
            Path path = Paths.get("./data/imagePDF.jpeg");
            Document documento = new Document();
            Font font = FontFactory.getFont(FontFactory.TIMES, 30, BaseColor.PINK);
            Image img = Image.getInstance(path.toAbsolutePath().toString());
            img.scaleToFit(200, 200);
            img.setAlignment(Element.ALIGN_LEFT);

            PdfWriter.getInstance(documento, new FileOutputStream(nombre));
            documento.open();
            documento.add(new Chunk("CURRICULUM VITAE \n\n", font));
            documento.add(new Paragraph("\n\n"));
            documento.add(img);
            documento.add(new Paragraph(candidate.candidateCurriculum()));

            documento.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
