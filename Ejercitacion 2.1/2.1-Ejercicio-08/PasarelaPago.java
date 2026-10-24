public class PasarelaPago {

    private static PasarelaPago instancia = null;

    // Constructor privado
    private PasarelaPago() {
        System.out.println("Pasarela de pago inicializada.");
    }

    // Obtiene la única instancia
    public static synchronized PasarelaPago getInstancia() {
        if (instancia == null) {
            instancia = new PasarelaPago();
        }
        return instancia;
    }

    // Simula el procesamiento de un pago
    public synchronized boolean procesarPago(
            String cliente, double monto) {

        if (cliente == null || cliente.isBlank() || monto <= 0) {
            System.out.println("Los datos del pago no son válidos.");
            return false;
        }

        System.out.println("Procesando pago...");
        System.out.println("Cliente: " + cliente);
        System.out.println("Monto: $" + monto);
        System.out.println("Pago procesado correctamente.");

        return true;
    }
}

