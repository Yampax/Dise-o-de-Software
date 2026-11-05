public class Comprobante {

    private String metodoPago;
    private double montoOriginal;
    private double comision;
    private double total;

    public Comprobante(String metodoPago, double montoOriginal,
                       double comision, double total) {

        this.metodoPago = metodoPago;
        this.montoOriginal = montoOriginal;
        this.comision = comision;
        this.total = total;
    }

    public void mostrarComprobante() {
        System.out.println("----- COMPROBANTE DE PAGO -----");
        System.out.println("Método: " + metodoPago);
        System.out.println("Monto original: $" + montoOriginal);
        System.out.println("Comisión: $" + comision);
        System.out.println("Total pagado: $" + total);
        System.out.println("------------------------------");
    }
}
