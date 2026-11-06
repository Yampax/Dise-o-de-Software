public class SolicitudFiscal {

    private final String pais;
    private final String razonSocial;
    private final String identificadorEmisor;
    private final String domicilio;
    private final String nombreReceptor;
    private final String identificadorReceptor;
    private final double subtotal;
    private final double impuesto;
    private final double total;
    private final String moneda;

    public SolicitudFiscal(String pais, String razonSocial,
                           String identificadorEmisor, String domicilio,
                           String nombreReceptor, String identificadorReceptor,
                           double subtotal, double impuesto,
                           double total, String moneda) {

        this.pais = pais;
        this.razonSocial = razonSocial;
        this.identificadorEmisor = identificadorEmisor;
        this.domicilio = domicilio;
        this.nombreReceptor = nombreReceptor;
        this.identificadorReceptor = identificadorReceptor;
        this.subtotal = subtotal;
        this.impuesto = impuesto;
        this.total = total;
        this.moneda = moneda;
    }

    public String getPais() {
        return pais;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getIdentificadorEmisor() {
        return identificadorEmisor;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getNombreReceptor() {
        return nombreReceptor;
    }

    public String getIdentificadorReceptor() {
        return identificadorReceptor;
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
