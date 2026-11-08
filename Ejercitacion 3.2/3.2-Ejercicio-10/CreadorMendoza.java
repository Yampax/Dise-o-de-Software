public class CreadorMendoza extends CreadorTitulo {

    @Override
    protected String obtenerJurisdiccion() {
        return "Mendoza";
    }

    @Override
    protected TituloPropiedad crearTitulo(
            DatosSolicitud datos,
            ContextoJurisdiccion contexto,
            String firma) {

        return new TituloMendoza(datos, contexto, firma);
    }
}
