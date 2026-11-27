public class CambioRiesgo {

    private final String cuenta;
    private final PerfilRiesgo riesgoAnterior;
    private final PerfilRiesgo riesgoNuevo;
    private final String motivo;

    public CambioRiesgo(String cuenta,
                        PerfilRiesgo riesgoAnterior,
                        PerfilRiesgo riesgoNuevo,
                        String motivo) {

        this.cuenta = cuenta;
        this.riesgoAnterior = riesgoAnterior;
        this.riesgoNuevo = riesgoNuevo;
        this.motivo = motivo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public PerfilRiesgo getRiesgoAnterior() {
        return riesgoAnterior;
    }

    public PerfilRiesgo getRiesgoNuevo() {
        return riesgoNuevo;
    }

    public String getMotivo() {
        return motivo;
    }
}
