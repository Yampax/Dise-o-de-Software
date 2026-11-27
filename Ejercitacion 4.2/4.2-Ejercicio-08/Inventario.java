import java.util.ArrayList;
import java.util.List;

public class Inventario implements Sujeto {

    private String nombreProducto;
    private int stock;

    private List<ObservadorStock> observadores;

    public Inventario(String nombreProducto, int stockInicial) {
        this.nombreProducto = nombreProducto;
        this.stock = stockInicial;
        this.observadores = new ArrayList<>();
    }

    @Override
    public void suscribir(ObservadorStock observador) {
        if (!observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void desuscribir(ObservadorStock observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {
        for (ObservadorStock observador : observadores) {
            observador.actualizarStock(nombreProducto, stock);
        }
    }

    public void modificarStock(int cantidad) {

        if (stock + cantidad < 0) {
            System.out.println("Error: no hay stock suficiente.");
            return;
        }

        stock += cantidad;

        System.out.println("\nStock actualizado de " + nombreProducto
                + ": " + stock);

        notificar();
    }

    public int getStock() {
        return stock;
    }
}
