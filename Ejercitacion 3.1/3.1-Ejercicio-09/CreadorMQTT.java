public class CreadorMQTT extends CreadorConector {

    @Override
    protected ConectorIoT crearConector(
            ConfiguracionIoT configuracion,
            MetricasConexion metricas
    ) throws ExcepcionConexion {

        try {

            return new ConectorMQTT(configuracion, metricas);

        } catch (RuntimeException e) {

            throw new ExcepcionConexion(
                "Error al construir el conector MQTT.", e
            );
        }
    }

    @Override
    protected String obtenerProtocolo() {
        return "MQTT";
    }
}
