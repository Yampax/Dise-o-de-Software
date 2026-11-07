public class DatosFactura {

    private final String numero;
    private final String cliente;
    private final double subtotal;
    private final double impuesto;

    public DatosFactura(String numero, String cliente,
                        double subtotal, double impuesto) {
        this.numero = numero;
        this.cliente = cliente;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
    }

    public String getNumero() {
        return numero;
    }

    public String getCliente() {
        return cliente;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getTotal() {
        return subtotal + impuesto;
    }
}
