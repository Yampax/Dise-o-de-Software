import java.util.concurrent.CopyOnWriteArrayList;

public class Tarea implements Sujeto {

    private String nombre;
    private EstadoTarea estado;

    private final CopyOnWriteArrayList<ObservadorTarea> observadores =
            new CopyOnWriteArrayList<>();

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.estado = EstadoTarea.PENDIENTE;
    }

    public void cambiarEstado(EstadoTarea nuevoEstado) {

        if (nuevoEstado == null) {
            throw new IllegalArgumentException(
                    "El estado no puede ser nulo");
        }

        if (this.estado == nuevoEstado) {
            return;
        }

        EstadoTarea estadoAnterior = this.estado;

        this.estado = nuevoEstado;

        notificar(estadoAnterior, nuevoEstado);
    }

    @Override
    public void suscribir(ObservadorTarea observador) {
        if (observador != null) {
            observadores.addIfAbsent(observador);
        }
    }

    @Override
    public void desuscribir(ObservadorTarea observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar(EstadoTarea estadoAnterior,
                          EstadoTarea estadoNuevo) {

        for (ObservadorTarea observador : observadores) {
            observador.actualizar(
                    nombre,
                    estadoAnterior,
                    estadoNuevo
            );
        }
    }
}
