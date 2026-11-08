public class TituloMendoza extends TituloPropiedad {

    public TituloMendoza(
            DatosSolicitud datos,
            ContextoJurisdiccion contexto,
            String firmaDigital) {

        super(datos, contexto, firmaDigital);
    }

    @Override
    public String obtenerFormato() {
        return "Formato registral de Mendoza";
    }
}
