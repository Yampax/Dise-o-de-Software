import java.util.concurrent.CopyOnWriteArrayList;

public class MonitorRed {

    private EstadoConexion estado;
    private final CopyOnWriteArrayList<ObservadorRed> observadores;

    public MonitorRed() {
        this.estado = EstadoConexion.DESCONECTADO;
        this.observadores = new CopyOnWriteArrayList<>();
    }

    public void suscribir(ObservadorRed observador) {
        observadores.addIfAbsent(observador);
    }

    public void desuscribir(ObservadorRed observador) {
        observadores.remove(observador);
    }

    public void cambiarEstado(EstadoConexion nuevoEstado) {

        if (nuevoEstado == null) {
            throw new IllegalArgumentException("El estado no puede ser nulo");
        }

        if (this.estado != nuevoEstado) {
            this.estado = nuevoEstado;

            System.out.println("\nEl estado de la red cambió a: " + estado);

            notificar();
        }
    }

    private void notificar() {
        for (ObservadorRed observador : observadores) {
            observador.actualizar(estado);
        }
    }
}
