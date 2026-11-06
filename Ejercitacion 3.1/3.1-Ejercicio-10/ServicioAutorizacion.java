public interface ServicioAutorizacion {

    String solicitarAutorizacion(
        SolicitudFiscal solicitud
    ) throws ExcepcionFiscal;
}
