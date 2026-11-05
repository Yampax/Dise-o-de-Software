public class PagoMonedero implements PasarelaPago {

    @Override
    public Comprobante procesarPago(double monto) {

        double comision = monto * 0.02;
        double total = monto + comision;

        System.out.println("Procesando pago con monedero digital...");

        return new Comprobante(
            "Monedero digital",
            monto,
            comision,
            total
        );
    }
}
