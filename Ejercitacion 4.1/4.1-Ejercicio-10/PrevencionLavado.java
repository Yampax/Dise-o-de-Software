public class PrevencionLavado implements ObservadorRegulatorio {

    @Override
    public String getNombre() {
        return "Prevención de Lavado";
    }

    @Override
    public void procesar(CambioRiesgo cambio) throws Exception {

        System.out.println(
                "Prevención de Lavado: analizando cliente " +
                cambio.getIdCliente()
        );

        // Simulación de una incidencia
        if (cambio.getPerfilNuevo() == PerfilRiesgo.CRITICO) {
            throw new Exception(
                    "Se requiere una revisión adicional del cliente"
            );
        }

        System.out.println(
                "Prevención de Lavado: análisis completado"
        );
    }
}
