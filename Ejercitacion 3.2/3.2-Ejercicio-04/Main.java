public class Main {

    public static void main(String[] args) {

        DatosFactura factura = new DatosFactura(
                "001",
                "Juan Perez",
                100000,
                21000
        );

        try {

            // Generar factura PDF.
            CreadorComprobante creadorPDF = new CreadorPDF();

            creadorPDF.generarComprobante(factura);

            // Generar ticket.
            CreadorComprobante creadorTicket = new CreadorTicket();

            creadorTicket.generarComprobante(factura);

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
