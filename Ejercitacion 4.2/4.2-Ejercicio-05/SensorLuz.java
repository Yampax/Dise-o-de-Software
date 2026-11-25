import java.util.ArrayList;
import java.util.List;

public class SensorLuz implements Sujeto {

    private double luminosidad;

    private final List<ObservadorLuz> observadores;

    public SensorLuz() {
        luminosidad = 0;
        observadores = new ArrayList<>();
    }

    @Override
    public void suscribir(ObservadorLuz observador) {

        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void desuscribir(ObservadorLuz observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {

        for (ObservadorLuz observador : observadores) {
            observador.actualizar(luminosidad);
        }
    }

    public void actualizarLuminosidad(double nuevaLuminosidad) {

        if (nuevaLuminosidad < 0) {
            System.out.println("La luminosidad no puede ser negativa.");
            return;
        }

        luminosidad = nuevaLuminosidad;

        System.out.println("\nLuminosidad exterior: " + luminosidad + " lux");

        notificar();
    }

    public double getLuminosidad() {
        return luminosidad;
    }
}
