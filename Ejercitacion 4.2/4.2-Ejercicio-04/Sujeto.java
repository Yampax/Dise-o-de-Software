public interface Sujeto {

    void suscribir(ObservadorPrecio observador);

    void desuscribir(ObservadorPrecio observador);

    void notificar(double precioAnterior,
                   double precioNuevo,
                   double porcentajeRebaja);
}
