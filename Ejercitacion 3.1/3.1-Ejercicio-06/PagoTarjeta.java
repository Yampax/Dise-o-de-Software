public class PagoTarjeta implements PasarelaPago {

    @Override
    public Comprobante procesarPago(double monto) {

        double comision = monto * 0.03;
        double total = monto + comision;

        System.out.println("Procesando pago con tarjeta...");

        return new Comprobante(
            "Tarjeta de crédito",
            monto,
            comision,
            total
        );
    }
}
