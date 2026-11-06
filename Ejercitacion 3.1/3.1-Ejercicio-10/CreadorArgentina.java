public class CreadorArgentina extends CreadorComprobante {

    @Override
    protected ComprobanteFiscal crearComprobante(
            String xml, String autorizacion, String firma) {

        return new ComprobanteArgentina(xml, autorizacion, firma);
    }

    @Override
    protected String construirXML(SolicitudFiscal solicitud) {

        return "<Comprobante pais=\"Argentina\">" +
                "<Emisor>" +
                "<RazonSocial>" + escaparXML(solicitud.getRazonSocial()) + "</RazonSocial>" +
                "<CUIT>" + escaparXML(solicitud.getIdentificadorEmisor()) + "</CUIT>" +
                "<Domicilio>" + escaparXML(solicitud.getDomicilio()) + "</Domicilio>" +
                "</Emisor>" +
                "<Receptor>" +
                "<Nombre>" + escaparXML(solicitud.getNombreReceptor()) + "</Nombre>" +
                "<Identificador>" + escaparXML(solicitud.getIdentificadorReceptor()) + "</Identificador>" +
                "</Receptor>" +
                "<Importes>" +
                "<Subtotal>" + solicitud.getSubtotal() + "</Subtotal>" +
                "<Impuesto>" + solicitud.getImpuesto() + "</Impuesto>" +
                "<Total>" + solicitud.getTotal() + "</Total>" +
                "<Moneda>ARS</Moneda>" +
                "</Importes>" +
                "</Comprobante>";
    }
}
