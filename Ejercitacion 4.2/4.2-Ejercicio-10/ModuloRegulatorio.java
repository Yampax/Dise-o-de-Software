public class ModuloRegulatorio implements ObservadorRiesgo {

    @Override
    public String getNombre() {
        return "Organismo Regulatorio";
    }

    @Override
    public void procesarCambio(CambioRiesgo cambio) {

        System.out.println("[REGULATORIO] Enviando reporte internacional.");

        if (cambio.getRiesgoNuevo() == PerfilRiesgo.CRITICO) {

            throw new RuntimeException(
                    "Error de conexión con el organismo internacional."
            );
        }

        System.out.println("[REGULATORIO] Reporte enviado correctamente.");
    }
}
