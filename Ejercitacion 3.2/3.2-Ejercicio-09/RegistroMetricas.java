import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import java.util.Map;

public class RegistroMetricas {

    private final Map<String, EstadoConexion> estados =
            new ConcurrentHashMap<>();

    private final LongAdder conexionesExitosas = new LongAdder();
    private final LongAdder conexionesFallidas = new LongAdder();

    public void registrarEstado(String protocolo, EstadoConexion estado) {
        estados.put(protocolo, estado);
    }

    public void registrarExito() {
        conexionesExitosas.increment();
    }

    public void registrarError() {
        conexionesFallidas.increment();
    }

    public void mostrarMetricas() {

        System.out.println("\n=== MÉTRICAS DEL SISTEMA ===");

        estados.forEach((protocolo, estado) ->
                System.out.println(protocolo + ": " + estado));

        System.out.println("Conexiones exitosas: "
                + conexionesExitosas.sum());

        System.out.println("Conexiones fallidas: "
                + conexionesFallidas.sum());
    }
}
