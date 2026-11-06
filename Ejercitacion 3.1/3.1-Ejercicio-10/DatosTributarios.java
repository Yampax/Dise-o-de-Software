public class DatosTributarios {

    private final double subtotal;
    private final double impuesto;
    private final double total;
    private final String moneda;

    public DatosTributarios(double subtotal,
                            double impuesto,
                            double total,
                            String moneda) {

        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
        this.moneda = moneda;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return total;
    }

    public String getMoneda() {
        return moneda;
    }
}
