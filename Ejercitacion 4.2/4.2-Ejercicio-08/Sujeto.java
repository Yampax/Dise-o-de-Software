public interface Sujeto {

    void suscribir(ObservadorStock observador);

    void desuscribir(ObservadorStock observador);

    void notificar();
}
