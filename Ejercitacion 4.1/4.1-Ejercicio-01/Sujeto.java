public interface Sujeto {
    void registrar(Observador observador);

    void eliminar(Observador observador);

    void notificar();
}
