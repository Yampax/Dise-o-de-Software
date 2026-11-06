public class CreadorHTTP extends CreadorConector {

    @Override
    protected ConectorIoT crearConector(
            ConfiguracionIoT configuracion,
            MetricasConexion metricas
    ) throws ExcepcionConexion {

        try {

            return new ConectorHTTP(configuracion, metricas);

        } catch (RuntimeException e) {

            throw new ExcepcionConexion(
                "Error al construir el conector HTTP.", e
            );
        }
    }

    @Override
    protected String obtenerProtocolo() {
        return "HTTP";
    }
}
