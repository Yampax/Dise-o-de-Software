import java.io.FileWriter;
import java.io.IOException;

public class GeneradorTicket implements GeneradorComprobante {

    @Override
    public void generar(DatosFactura datos) {

        validar(datos);

        try (FileWriter archivo =
                     new FileWriter("Ticket_" + datos.getNumero() + ".txt")) {

            archivo.write("==============================\n");
            archivo.write("       TICKET DE CAJA\n");
            archivo.write("==============================\n");
            archivo.write("Numero: " + datos.getNumero() + "\n");
            archivo.write("Cliente: " + datos.getCliente() + "\n");
            archivo.write("------------------------------\n");
            archivo.write("Subtotal: $" + datos.getSubtotal() + "\n");
            archivo.write("Impuestos: $" + datos.getImpuesto() + "\n");
            archivo.write("------------------------------\n");
            archivo.write("TOTAL: $" + datos.getTotal() + "\n");
            archivo.write("==============================\n");

            System.out.println("Ticket generado correctamente.");

        } catch (IOException e) {
            System.out.println("Error al generar ticket: " + e.getMessage());
        }
    }

    private void validar(DatosFactura datos) {

        if (datos == null) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos.");
        }

        if (datos.getNumero() == null || datos.getNumero().isBlank()
                || datos.getCliente() == null || datos.getCliente().isBlank()) {
            throw new IllegalArgumentException("Faltan datos del ticket.");
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
