public interface ConectorSensor extends AutoCloseable {

    void inicializar(ConfiguracionSensor configuracion) throws SensorException;

    String leerDatos() throws SensorException;

    EstadoConexion getEstado();

    @Override
    void close();
}
