import java.util.concurrent.atomic.AtomicReference;

public abstract class ConectorBase implements ConectorSensor {

    private final AtomicReference<EstadoConexion> estado =
            new AtomicReference<>(EstadoConexion.DESCONECTADO);

    @Override
    public final void inicializar(ConfiguracionSensor configuracion)
            throws SensorException {

        if (!estado.compareAndSet(
                EstadoConexion.DESCONECTADO,
                EstadoConexion.INICIALIZANDO)) {

            throw new SensorException("El conector ya fue inicializado.");
        }

        try {
            validarConfiguracion(configuracion);
            abrirPuerto(configuracion);
            estado.set(EstadoConexion.CONECTADO);

        } catch (Exception e) {
            estado.set(EstadoConexion.ERROR);
            close();

            throw new SensorException(
                    "Error al inicializar el conector: " + e.getMessage(), e);
        }
    }

    protected abstract void validarConfiguracion(
            ConfiguracionSensor configuracion) throws Exception;

    protected abstract void abrirPuerto(
            ConfiguracionSensor configuracion) throws Exception;

    @Override
    public final String leerDatos() throws SensorException {

        if (estado.get() != EstadoConexion.CONECTADO) {
            throw new SensorException("El sensor no está conectado.");
        }

        return realizarLectura();
    }

    protected abstract String realizarLectura() throws SensorException;

    @Override
    public EstadoConexion getEstado() {
        return estado.get();
    }

    @Override
public void close() {
    if (estado.get() != EstadoConexion.ERROR) {
        estado.set(EstadoConexion.DESCONECTADO);
    }
}
