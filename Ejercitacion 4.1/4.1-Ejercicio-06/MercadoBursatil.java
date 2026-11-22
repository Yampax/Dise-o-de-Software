import java.util.concurrent.CopyOnWriteArrayList;

public class MercadoBursatil implements Sujeto {

    private Cotizacion cotizacionActual;

    private final CopyOnWriteArrayList<Observador> observadores =
            new CopyOnWriteArrayList<>();

    public MercadoBursatil(String activo, double precioInicial) {
        if (precioInicial <= 0) {
            throw new IllegalArgumentException(
                    "El precio inicial debe ser mayor a cero."
            );
        }

        this.cotizacionActual = new Cotizacion(
                activo, precioInicial, 0
        );
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
    public void notificar() {
        for (Observador observador : observadores) {
            observador.actualizar(cotizacionActual);
        }
    }

    public synchronized void actualizarPrecio(double nuevoPrecio) {

        if (nuevoPrecio <= 0) {
            System.out.println("El precio debe ser mayor a cero.");
            return;
        }

        double precioAnterior = cotizacionActual.getPrecio();

        double variacion = ((nuevoPrecio - precioAnterior)
                / precioAnterior) * 100;

        cotizacionActual = new Cotizacion(
                cotizacionActual.getActivo(),
                nuevoPrecio,
                variacion
        );

        notificar();
    }
}
