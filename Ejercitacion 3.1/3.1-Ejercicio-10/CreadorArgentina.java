public class CreadorArgentina extends CreadorComprobante {

    public CreadorArgentina(
            ServicioAutorizacion autorizacion,
            ServicioFirmaDigital firma) {

        super(autorizacion, firma);
    }

    @Override
    protected String construirXML(
            SolicitudFiscal solicitud) {

        return "<ComprobanteArgentina>"
            + "<Emisor>"
            + escapar(solicitud.getEmisor().getRazonSocial())
            + "</Emisor>"
            + "<CUIT>"
            + escapar(solicitud.getEmisor().getIdentificadorFiscal())
            + "</CUIT>"
            + "<Receptor>"
            + escapar(solicitud.getReceptor().getNombre())
            + "</Receptor>"
            + "<Total>"
            + solicitud.getDatos().getTotal()
            + "</Total>"
            + "<Moneda>"
            + escapar(solicitud.getDatos().getMoneda())
            + "</Moneda>"
            + "</ComprobanteArgentina>";
    }

    @Override
    protected ComprobanteFiscal crearComprobante(
            String xml,
            String autorizacion,
            String firma) {

        return new ComprobanteArgentina(
            xml,
            autorizacion,
            firma
        );
    }

    private String escapar(String texto) {

        return texto.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&apos;");
    }
}
