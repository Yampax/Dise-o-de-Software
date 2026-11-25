import java.util.ArrayList;
import java.util.List;

public class Producto implements Sujeto {

    private String nombre;
    private double precio;

    private final List<ObservadorPrecio> observadores;

    public Producto(String nombre, double precio) {

        if (precio <= 0) {
            throw new IllegalArgumentException(
                "El precio debe ser mayor a cero."
            );
        }

        this.nombre = nombre;
        this.precio = precio;
        this.observadores = new ArrayList<>();
    }

    @Override
    public void suscribir(ObservadorPrecio observador) {

        if (observador != null && !observadores.contains(observador)) {
            observadores.add(observador);
        }
    }

    @Override
    public void desuscribir(ObservadorPrecio observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar(double precioAnterior,
                          double precioNuevo,
                          double porcentajeRebaja) {

        for (ObservadorPrecio observador : observadores) {

            observador.actualizar(
                nombre,
                precioAnterior,
                precioNuevo,
                porcentajeRebaja
            );
        }
    }

    public void actualizarPrecio(double nuevoPrecio) {

        if (nuevoPrecio <= 0) {
            System.out.println("El precio debe ser mayor a cero.");
            return;
        }

        double precioAnterior = this.precio;

        // Actualizar el precio del producto
        this.precio = nuevoPrecio;

        System.out.println("\nProducto: " + nombre);
        System.out.println("Precio anterior: $" + precioAnterior);
        System.out.println("Precio nuevo: $" + nuevoPrecio);

        // Comprobar si el precio disminuyó
        if (nuevoPrecio < precioAnterior) {

            double rebaja = precioAnterior - nuevoPrecio;

            double porcentajeRebaja =
                (rebaja / precioAnterior) * 100;

            System.out.printf(
                "Rebaja aplicada: %.2f%%%n",
                porcentajeRebaja
            );

            notificar(
                precioAnterior,
                nuevoPrecio,
                porcentajeRebaja
            );

        } else {

            System.out.println(
                "No hay rebaja. No se envían notificaciones."
            );
        }
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
