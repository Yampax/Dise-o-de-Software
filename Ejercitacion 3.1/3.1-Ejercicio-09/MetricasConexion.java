import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class MetricasConexion {

    private String protocolo;

    private AtomicReference<EstadoConexion> estado;

    private AtomicInteger conexionesExitosas;

    private AtomicInteger reconexiones;

    private AtomicInteger errores;

    public MetricasConexion(String protocolo) {

        this.protocolo = protocolo;

        estado = new AtomicReference<>(
            EstadoConexion.DESCONECTADO
        );

        conexionesExitosas = new AtomicInteger(0);
        reconexiones = new AtomicInteger(0);
        errores = new AtomicInteger(0);
    }

    public void actualizarEstado(EstadoConexion nuevoEstado) {
        estado.set(nuevoEstado);
    }

    public void registrarConexion() {
        conexionesExitosas.incrementAndGet();
    }

    public void registrarReconectar() {
        reconexiones.incrementAndGet();
    }

    public void registrarError() {
        errores.incrementAndGet();
    }

    public void mostrarMetricas() {

        System.out.println("Protocolo: " + protocolo);
        System.out.println("Estado: " + estado.get());
        System.out.println("Conexiones exitosas: "
                           + conexionesExitosas.get());
        System.out.println("Reconexiones: " + reconexiones.get());
        System.out.println("Errores: " + errores.get());
    }
}
