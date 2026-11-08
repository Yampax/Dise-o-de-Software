public final class ContextoJurisdiccion {

    private final String jurisdiccion;
    private final String organismo;
    private final String codigoNotarial;

    public ContextoJurisdiccion(
            String jurisdiccion,
            String organismo,
            String codigoNotarial) {

        if (jurisdiccion == null || jurisdiccion.isBlank()
                || organismo == null || organismo.isBlank()
                || codigoNotarial == null || codigoNotarial.isBlank()) {
            throw new IllegalArgumentException(
                    "Faltan datos obligatorios de la jurisdicción.");
        }

        this.jurisdiccion = jurisdiccion;
        this.organismo = organismo;
        this.codigoNotarial = codigoNotarial;
    }

    public String getJurisdiccion() {
        return jurisdiccion;
    }

    public String getOrganismo() {
        return organismo;
    }

    public String getCodigoNotarial() {
        return codigoNotarial;
    }
}
