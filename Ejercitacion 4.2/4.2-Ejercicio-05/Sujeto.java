public interface Sujeto {

    void suscribir(ObservadorLuz observador);

    void desuscribir(ObservadorLuz observador);

    void notificar();
}
