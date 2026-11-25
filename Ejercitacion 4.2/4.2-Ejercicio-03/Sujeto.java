public interface Sujeto {

    void suscribir(ObservadorPuntuacion observador);

    void desuscribir(ObservadorPuntuacion observador);

    void notificar();
}
