public class AlertaCPU implements ObservadorEvento {

    @Override
    public void procesarEvento(Evento evento) {

        System.out.println("[CPU] Procesando alerta: "
                + evento.getSeveridad());

        System.out.println("[CPU] " + evento.getDescripcion());

        if (evento.getSeveridad().equals("CRITICA")) {
            System.out.println("[CPU] Ejecutando reducción de carga.");
        }
    }
}
