public interface Sujeto {
    void suscribir(ObservadorTarea observador);

    void desuscribir(ObservadorTarea observador);

    void notificar(EstadoTarea estadoAnterior,
                   EstadoTarea estadoNuevo);
}
