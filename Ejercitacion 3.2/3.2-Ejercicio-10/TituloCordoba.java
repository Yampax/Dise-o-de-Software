public class TituloCordoba extends TituloPropiedad {

    public TituloCordoba(
            DatosSolicitud datos,
            ContextoJurisdiccion contexto,
            String firmaDigital) {

        super(datos, contexto, firmaDigital);
    }

    @Override
    public String obtenerFormato() {
        return "Formato registral de Córdoba";
    }
}
