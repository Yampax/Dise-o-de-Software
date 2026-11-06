public class CreadorCoAP extends CreadorConector {

    @Override
    protected ConectorIoT crearConector(
            ConfiguracionIoT configuracion,
            MetricasConexion metricas
    ) throws ExcepcionConexion {

        try {

            return new ConectorCoAP(configuracion, metricas);

        } catch (RuntimeException e) {

            throw new ExcepcionConexion(
                "Error al construir el conector CoAP.", e
            );
        }
    }

    @Override
    protected String obtenerProtocolo() {
        return "CoAP";
    }
}
