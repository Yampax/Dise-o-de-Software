public class PagoTransferencia implements PasarelaPago {

    @Override
    public Comprobante procesarPago(double monto) {

        double comision = monto * 0.01;
        double total = monto + comision;

        System.out.println("Procesando transferencia bancaria...");

        return new Comprobante(
            "Transferencia bancaria",
            monto,
            comision,
            total
        );
    }
}
