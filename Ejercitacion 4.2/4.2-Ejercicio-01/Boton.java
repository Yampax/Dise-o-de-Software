import java.util.ArrayList;
import java.util.List;

public class Boton {

    private final List<ObservadorClick> observadores =
            new ArrayList<>();

    public void suscribir(ObservadorClick observador) {
        if (observador != null) {
            observadores.add(observador);
        }
    }

    public void desuscribir(ObservadorClick observador) {
        observadores.remove(observador);
    }

    public void hacerClick() {

        System.out.println("¡Botón presionado!");

        for (ObservadorClick observador : observadores) {
            observador.alHacerClick();
        }
    }
}
