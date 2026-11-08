public class CreadorCordoba extends CreadorTitulo {

    @Override
    protected String obtenerJurisdiccion() {
        return "Córdoba";
    }

    @Override
    protected TituloPropiedad crearTitulo(
            DatosSolicitud datos,
            ContextoJurisdiccion contexto,
            String firma) {

        return new TituloCordoba(datos, contexto, firma);
    }
}
