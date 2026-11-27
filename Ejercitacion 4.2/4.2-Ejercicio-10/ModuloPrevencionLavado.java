public class ModuloPrevencionLavado implements ObservadorRiesgo {

    @Override
    public String getNombre() {
        return "Prevención de Lavado";
    }

    @Override
    public void procesarCambio(CambioRiesgo cambio) {

        System.out.println("[AML] Analizando posibles riesgos de lavado.");

        if (cambio.getRiesgoNuevo() == PerfilRiesgo.ALTO
                || cambio.getRiesgoNuevo() == PerfilRiesgo.CRITICO) {

            System.out.println("[AML] Se genera una alerta para revisión.");
        }

        System.out.println("[AML] Análisis finalizado.");
    }
}
