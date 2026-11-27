public class AlertaDisco implements ObservadorEvento {

    @Override
    public void procesarEvento(Evento evento) {

        System.out.println("[DISCO] "
                + evento.getDescripcion());

        System.out.println("[DISCO] Iniciando revisión del almacenamiento.");
    }
}
