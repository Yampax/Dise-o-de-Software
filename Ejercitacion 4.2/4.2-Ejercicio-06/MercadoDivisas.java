import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class MercadoDivisas implements Sujeto {

    private final ConcurrentHashMap<String, Double> cotizaciones;

    private final CopyOnWriteArrayList<ObservadorCotizacion> observadores;

    public MercadoDivisas() {
        cotizaciones = new ConcurrentHashMap<>();
        observadores = new CopyOnWriteArrayList<>();
    }

    @Override
    public void suscribir(ObservadorCotizacion observador) {

        if (observador != null) {
            observadores.addIfAbsent(observador);
        }
    }

    @Override
    public void desuscribir(ObservadorCotizacion observador) {
        observadores.remove(observador);
    }

    @Override
    public void notificar(Cotizacion cotizacion) {

        for (ObservadorCotizacion observador : observadores) {
            observador.actualizar(cotizacion);
        }
    }

    public synchronized void actualizarCotizacion(
            String moneda,
            double nuevoPrecio) {

        if (moneda == null || moneda.isBlank()) {
            System.out.println("La moneda no es válida.");
            return;
        }

        if (nuevoPrecio <= 0) {
            System.out.println("El precio debe ser mayor a cero.");
            return;
        }

        moneda = moneda.toUpperCase();

        // Obtener el precio anterior
        Double precioAnterior = cotizaciones.get(moneda);

        // Si es la primera cotización, se inicializa
        if (precioAnterior == null) {

            cotizaciones.put(moneda, nuevoPrecio);

            Cotizacion cotizacion = new Cotizacion(
                moneda,
                nuevoPrecio,
                0
            );

            System.out.println("\nPrimera cotización de " + moneda);
            System.out.println("Precio: $" + nuevoPrecio);

            notificar(cotizacion);

            return;
        }

        // Calcular la variación porcentual
        double variacion =
            ((nuevoPrecio - precioAnterior) / precioAnterior) * 100;

        // Actualizar la cotización almacenada
        cotizaciones.put(moneda, nuevoPrecio);

        // Crear objeto con los datos actualizados
        Cotizacion cotizacion = new Cotizacion(
            moneda,
            nuevoPrecio,
            variacion
        );

        System.out.println("\nCotización actualizada: " + moneda);
        System.out.println("Precio anterior: $" + precioAnterior);
        System.out.println("Precio nuevo: $" + nuevoPrecio);

        System.out.printf(
            "Variación: %.2f%%%n",
            variacion
        );

        // Notificar a todos los observadores
        notificar(cotizacion);
    }

    public double getCotizacion(String moneda) {

        Double precio = cotizaciones.get(moneda.toUpperCase());

        if (precio == null) {
            throw new IllegalArgumentException(
                "La moneda no tiene una cotización registrada."
            );
        }

        return precio;
    }
}
