import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Reproductor implements Sujeto {

    private String cancionActual;
    private EstadoReproduccion estado;

    private final CopyOnWriteArrayList<Observador> observadores =
        new CopyOnWriteArrayList<>();

    public Reproductor() {
        this.cancionActual = "Sin canción";
        this.estado = EstadoReproduccion.DETENIDO;
    }

    @Override
    public void suscribir(Observador observador) {
        if (observador != null) {
            observadores.addIfAbsent(observador);
        }
    }

    @Override
    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizar(cancionActual, estado);
        }
    }

    public void cambiarCancion(String nuevaCancion) {
        this.cancionActual = nuevaCancion;
        notificar();
    }

    public void cambiarEstado(EstadoReproduccion nuevoEstado) {
        this.estado = nuevoEstado;
        notificar();
    }
}
