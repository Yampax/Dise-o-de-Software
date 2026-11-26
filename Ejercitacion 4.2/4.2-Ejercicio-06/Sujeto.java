public interface Sujeto {

    void suscribir(ObservadorCotizacion observador);

    void desuscribir(ObservadorCotizacion observador);

    void notificar(Cotizacion cotizacion);
}
