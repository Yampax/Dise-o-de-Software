public class ModuloLegal implements ObservadorRiesgo {

    @Override
    public String getNombre() {
        return "Análisis Legal";
    }

    @Override
    public void procesarCambio(CambioRiesgo cambio) {

        System.out.println("[LEGAL] Revisando implicancias legales.");

        System.out.println("[LEGAL] Cuenta: " + cambio.getCuenta());

        System.out.println("[LEGAL] Motivo: " + cambio.getMotivo());

        System.out.println("[LEGAL] Revisión finalizada.");
    }
}
