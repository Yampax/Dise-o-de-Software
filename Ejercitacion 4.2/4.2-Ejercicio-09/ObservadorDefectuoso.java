public class ObservadorDefectuoso implements ObservadorEvento {

    @Override
    public void procesarEvento(Evento evento) {

        System.out.println("[OBSERVADOR DEFECTUOSO] Procesando evento...");

        throw new RuntimeException("Error interno del módulo.");
    }
}
