import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class GestorSensores {

    private final RegistroFactorias registro;
    private final RegistroMetricas metricas;

    private final Map<String, ConectorSensor> sensores =
            new ConcurrentHashMap<>();

    public GestorSensores(
            RegistroFactorias registro,
            RegistroMetricas metricas) {

        this.registro = registro;
        this.metricas = metricas;
    }

    public void conectarSensor(
            String id,
            String protocolo,
            ConfiguracionSensor config) throws SensorException {

        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Identificador inválido.");
        }

        CreadorConector creador = registro.obtener(protocolo);

        try {
            ConectorSensor conector = creador.conectar(config);

            if (sensores.putIfAbsent(id, conector) != null) {
                conector.close();
                throw new IllegalArgumentException(
                        "Ya existe un sensor con ese identificador.");
            }

            metricas.registrarEstado(
                    protocolo, conector.getEstado());

            metricas.registrarExito();

        } catch (SensorException e) {

            metricas.registrarEstado(protocolo, EstadoConexion.ERROR);
            metricas.registrarError();

            throw e;
        }
    }

    public void leerSensor(String id) throws SensorException {

        ConectorSensor conector = sensores.get(id);

        if (conector == null) {
            throw new SensorException("Sensor no encontrado.");
        }

        System.out.println(id + " -> " + conector.leerDatos());
    }

    public void desconectarSensor(String id) {

        ConectorSensor conector = sensores.remove(id);

        if (conector != null) {
            conector.close();
        }
    }

    public void mostrarMetricas() {
        metricas.mostrarMetricas();
    }
}
