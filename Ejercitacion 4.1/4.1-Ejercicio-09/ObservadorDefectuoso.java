public class ObservadorDefectuoso implements ObservadorEvento {

    @Override
    public void actualizar(Evento evento) {

        throw new RuntimeException(
                "No se pudo procesar el evento"
        );
    }
}
