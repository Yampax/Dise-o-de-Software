public class ServicioEstadisticas implements ObservadorEvento {

    @Override
    public void actualizar(Evento evento) {

        System.out.println(
                "Estadísticas: se registró el evento " +
                        evento.getTipo()
        );
    }
}
