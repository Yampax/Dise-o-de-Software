public class ServicioCompra {

    private final PasarelaPago pasarela;

    public ServicioCompra(PasarelaPago pasarela) {
        if (pasarela == null) {
            throw new IllegalArgumentException(
                    "La pasarela de pago no puede ser nula.");
        }

        this.pasarela = pasarela;
    }

    public void comprar(String cliente, double monto) {
        System.out.println("Iniciando compra...");

        boolean pagoExitoso =
                pasarela.procesarPago(cliente, monto);

        if (pagoExitoso) {
            System.out.println("Compra finalizada correctamente.");
        } else {
            System.out.println("No se pudo completar la compra.");
        }
    }

    public PasarelaPago obtenerPasarela() {
        return pasarela;
    }

}

