import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

import java.io.IOException;

public class GeneradorPDF implements GeneradorComprobante {

    @Override
    public void generar(DatosFactura datos) {

        validar(datos);

        try (PDDocument documento = new PDDocument()) {

            PDPage pagina = new PDPage(PDRectangle.A4);
            documento.addPage(pagina);

            try (PDPageContentStream contenido =
                         new PDPageContentStream(documento, pagina)) {

                contenido.beginText();
                contenido.setFont(
                        new PDType1Font(Standard14Fonts.FontName.HELVETICA_BOLD),
                        18
                );
                contenido.newLineAtOffset(50, 750);
                contenido.showText("FACTURA COMERCIAL");
                contenido.endText();

                contenido.beginText();
                contenido.setFont(
                        new PDType1Font(Standard14Fonts.FontName.HELVETICA),
                        12
                );
                contenido.newLineAtOffset(50, 700);
                contenido.showText("Numero: " + datos.getNumero());
                contenido.newLineAtOffset(0, -25);
                contenido.showText("Cliente: " + datos.getCliente());
                contenido.newLineAtOffset(0, -35);
                contenido.showText("Subtotal: $" + datos.getSubtotal());
                contenido.newLineAtOffset(0, -25);
                contenido.showText("Impuestos: $" + datos.getImpuesto());
                contenido.newLineAtOffset(0, -25);
                contenido.showText("TOTAL: $" + datos.getTotal());
                contenido.endText();
            }

            documento.save("Factura_" + datos.getNumero() + ".pdf");

            System.out.println("Factura PDF generada correctamente.");

        } catch (IOException e) {
            System.out.println("Error al generar PDF: " + e.getMessage());
        }
    }

    private void validar(DatosFactura datos) {

        if (datos == null) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos.");
        }

        if (datos.getNumero() == null || datos.getNumero().isBlank()
                || datos.getCliente() == null || datos.getCliente().isBlank()) {
            throw new IllegalArgumentException("Faltan datos de la factura.");
        }

        if (!Double.isFinite(datos.getSubtotal())
                || !Double.isFinite(datos.getImpuesto())
                || datos.getSubtotal() < 0
                || datos.getImpuesto() < 0
                || datos.getTotal() <= 0) {
            throw new IllegalArgumentException("Los importes son inválidos.");
        }
    }
}
