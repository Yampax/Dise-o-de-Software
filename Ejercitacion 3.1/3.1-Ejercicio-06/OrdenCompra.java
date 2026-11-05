public class OrdenCompra {

    private String metodoPago;
    private double monto;

    public OrdenCompra(String metodoPago, double monto) {
        this.metodoPago = metodoPago;
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public double getMonto() {
        return monto;
    }
}
