public interface Sujeto {
    void suscribir(Auditor auditor);
    void desuscribir(Auditor auditor);
    void notificar(String mensaje);
}
