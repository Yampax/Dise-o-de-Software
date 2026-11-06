
public class ComprobanteArgentina implements ComprobanteFiscal {

    private final String xml;
    private final String autorizacion;
    private final String firma;

    public ComprobanteArgentina(String xml, String autorizacion, String firma) {
        this.xml = xml;
        this.autorizacion = autorizacion;
        this.firma = firma;
    }

    @Override
    public String obtenerXML() {
        return xml;
    }

    @Override
    public String obtenerAutorizacion() {
        return autorizacion;
    }

    @Override
    public String obtenerFirma() {
        return firma;
    }

    @Override
    public void mostrarComprobante() {
        System.out.println("=== COMPROBANTE ARGENTINO ===");
        System.out.println("XML: " + xml);
        System.out.println("Autorización: " + autorizacion);
        System.out.println("Firma digital: " + firma);
    }
}
