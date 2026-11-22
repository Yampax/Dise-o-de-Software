import java.util.ArrayList;
import java.util.List;

public class Producto implements Sujeto {

    private String nombre;
    private int stock;
    private int umbralMinimo;

    private final List<Observador> observadores = new ArrayList<>();

    public Producto(String nombre, int stock, int umbralMinimo) {
        this.nombre = nombre;
        this.stock = stock;
        this.umbralMinimo = umbralMinimo;
    }

    @Override
    public void suscribir(Observador observador) {
        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void desuscribir(Observador observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizar(nombre, stock);
        }
    }

    public void vender(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor a cero.");
            return;
        }

        if (cantidad > stock) {
            System.out.println("No hay suficiente stock disponible.");
            return;
        }

        stock -= cantidad;

        System.out.println("Venta realizada: " + cantidad + " unidades.");
        System.out.println("Stock actual: " + stock);

        if (stock < umbralMinimo) {
            System.out.println("¡ALERTA! Stock por debajo del mínimo.");
            notificar();
        }
    }

    public int getStock() {
        return stock;
    }

    public String getNombre() {
        return nombre;
    }
}
