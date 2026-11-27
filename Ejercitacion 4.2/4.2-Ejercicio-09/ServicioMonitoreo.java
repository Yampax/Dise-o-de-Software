public class ServicioMonitoreo implements ObservadorEvento {

    @Override
    public void procesarEvento(Evento evento) {

        System.out.println("[MONITOREO] Nueva incidencia registrada.");
        System.out.println("[MONITOREO] Tipo: " + evento.getTipo());
        System.out.println("[MONITOREO] Severidad: "
                + evento.getSeveridad());
        System.out.println("[MONITOREO] Detalle: "
                + evento.getDescripcion());
    }
}
