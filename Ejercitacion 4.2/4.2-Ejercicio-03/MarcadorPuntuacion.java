import java.util.ArrayList;
import java.util.List;

public class MarcadorPuntuacion implements Sujeto {

    private int puntuacion;

    private List<ObservadorPuntuacion> observadores;

    public MarcadorPuntuacion() {
        puntuacion = 0;
        observadores = new ArrayList<>();
    }

    @Override
    public void suscribir(ObservadorPuntuacion observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void desuscribir(ObservadorPuntuacion observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {
        for (ObservadorPuntuacion observador : observadores) {
            observador.actualizar(puntuacion);
        }
    }

    public void sumarPuntos(int puntos) {

        if (puntos <= 0) {
            System.out.println("La cantidad de puntos debe ser positiva.");
            return;
        }

        puntuacion += puntos;

        System.out.println("\nSe sumaron " + puntos + " puntos.");

        notificar();
    }

    public int getPuntuacion() {
        return puntuacion;
    }
}
