public class CreadorEspana extends CreadorComprobante {

    public CreadorEspana(
            ServicioAutorizacion autorizacion,
            ServicioFirmaDigital firma) {

        super(autorizacion, firma);
    }

    @Override
    protected String construirXML(
            SolicitudFiscal solicitud) {

        return "<FacturaEspana>"
            + "<Emisor>"
            + escapar(solicitud.getEmisor().getRazonSocial())
            + "</Emisor>"
            + "<NIF>"
            + escapar(solicitud.getEmisor().getIdentificadorFiscal())
            + "</NIF>"
            + "<Receptor>"
            + escapar(solicitud.getReceptor().getNombre())
            + "</Receptor>"
            + "<Total>"
            + solicitud.getDatos().getTotal()
            + "</Total>"
            + "<Moneda>"
            + escapar(solicitud.getDatos().getMoneda())
            + "</Moneda>"
            + "</FacturaEspana>";
    }

    @Override
    protected ComprobanteFiscal crearComprobante(
            String xml,
            String autorizacion,
            String firma) {

        return new ComprobanteEspana(
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
