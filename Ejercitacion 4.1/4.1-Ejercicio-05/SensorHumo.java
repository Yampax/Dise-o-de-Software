import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SensorHumo implements Sujeto {

    private String ubicacion;

    private final CopyOnWriteArrayList<Observador> observadores =
        new CopyOnWriteArrayList<>();

    public SensorHumo(String ubicacion) {
        this.ubicacion = ubicacion;
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
    public void notificar(String mensaje) {
        for (Observador observador : observadores) {
            observador.actualizar(ubicacion, mensaje);
        }
    }

    public void detectarHumo() {
        System.out.println("\n¡HUMO DETECTADO!");
        System.out.println("Ubicación: " + ubicacion);

        notificar("Se detectó humo. Activar protocolo de emergencia.");
    }
}
