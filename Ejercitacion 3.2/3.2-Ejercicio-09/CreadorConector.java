public abstract class CreadorConector {

    protected abstract ConectorSensor crearConector();

    public final ConectorSensor conectar(ConfiguracionSensor config)
            throws SensorException {

        ConectorSensor conector = crearConector();

        try {
            conector.inicializar(config);
            return conector;

        } catch (SensorException e) {
            conector.close();

            throw new SensorException(
                    "No se pudo inicializar el protocolo: " + e.getMessage(), e);
        }
    }
}
