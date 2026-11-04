public class ReporteFinanciero {

    private String encabezado;
    private String concepto;
    private double importe;

    public ReporteFinanciero(String encabezado,
                             String concepto,
                             double importe) {
        this.encabezado = encabezado;
        this.concepto = concepto;
        this.importe = importe;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public String getConcepto() {
        return concepto;
    }

    public double getImporte() {
        return importe;
    }
}
