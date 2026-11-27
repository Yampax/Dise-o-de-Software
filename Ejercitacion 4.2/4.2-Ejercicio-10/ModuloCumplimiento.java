public class ModuloCumplimiento implements ObservadorRiesgo {

    @Override
    public String getNombre() {
        return "Cumplimiento Normativo";
    }

    @Override
    public void procesarCambio(CambioRiesgo cambio) {

        System.out.println("[CUMPLIMIENTO] Analizando cambio de riesgo.");

        if (cambio.getRiesgoNuevo() == PerfilRiesgo.CRITICO) {
            System.out.println("[CUMPLIMIENTO] Se requiere revisión especial.");
        }

        System.out.println("[CUMPLIMIENTO] Análisis finalizado.");
    }
}
