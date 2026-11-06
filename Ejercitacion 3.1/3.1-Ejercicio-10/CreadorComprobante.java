public abstract class CreadorComprobante {

    protected final ServicioAutorizacion servicioAutorizacion;
    protected final ServicioFirmaDigital servicioFirma;

    public CreadorComprobante(
            ServicioAutorizacion servicioAutorizacion,
            ServicioFirmaDigital servicioFirma) {

        this.servicioAutorizacion = servicioAutorizacion;
        this.servicioFirma = servicioFirma;
    }

    protected abstract ComprobanteFiscal crearComprobante(
        String xml,
        String autorizacion,
        String firma
    );

    protected abstract String construirXML(
        SolicitudFiscal solicitud
    ) throws ExcepcionFiscal;

    public final ComprobanteFiscal emitir(
            SolicitudFiscal solicitud
    ) throws ExcepcionFiscal {

        // 1. Validar los datos fiscales.
        ValidadorFiscal.validar(solicitud);

        // 2. Construir el documento XML.
        String xml = construirXML(solicitud);

        // 3. Solicitar autorización fiscal.
        String autorizacion =
            servicioAutorizacion.solicitarAutorizacion(solicitud);

        if (autorizacion == null || autorizacion.isBlank()) {
            throw new ExcepcionFiscal(
                "No se recibió una autorización válida."
            );
        }

        // 4. Firmar el documento.
        String firma = servicioFirma.firmar(xml);

        if (firma == null || firma.isBlank()) {
            throw new ExcepcionFiscal(
                "No se pudo obtener la firma digital."
            );
        }

        // 5. Crear y devolver el comprobante.
        return crearComprobante(xml, autorizacion, firma);
    }
}
