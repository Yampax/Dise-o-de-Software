public class AlertaMemoria implements ObservadorEvento {

    @Override
    public void procesarEvento(Evento evento) {

        System.out.println("[MEMORIA] "
                + evento.getDescripcion());

        if (evento.getSeveridad().equals("CRITICA")) {
            System.out.println("[MEMORIA] Liberando recursos.");
        }
    }
}
