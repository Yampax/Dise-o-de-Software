public class CreadorEspana extends CreadorComprobante {

    @Override
    protected ComprobanteFiscal crearComprobante(
            String xml, String autorizacion, String firma) {

        return new ComprobanteEspana(xml, autorizacion, firma);
    }

    @Override
    protected String construirXML(SolicitudFiscal solicitud) {

        return "<Comprobante pais=\"España\">" +
                "<Emisor>" +
                "<RazonSocial>" + escaparXML(solicitud.getRazonSocial()) + "</RazonSocial>" +
                "<IdentificadorFiscal>" + escaparXML(solicitud.getIdentificadorEmisor()) + "</IdentificadorFiscal>" +
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
                "<Moneda>EUR</Moneda>" +
                "</Importes>" +
                "</Comprobante>";
    }
}
