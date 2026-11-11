import java.util.ArrayList;
import java.util.List;

public class EstacionMeteorologica implements Sujeto {

    private double temperatura;

    private List<Observador> observadores = new ArrayList<>();

    @Override
    public void registrar(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void eliminar(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {

        for (Observador observador : observadores) {
            observador.actualizar(temperatura);
        }

    }

    public void setTemperatura(double temperatura) {

        this.temperatura = temperatura;

        notificar();
    }
}
