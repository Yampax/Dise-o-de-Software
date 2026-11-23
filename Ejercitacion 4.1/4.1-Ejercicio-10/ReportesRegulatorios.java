public class ReportesRegulatorios implements ObservadorRegulatorio {

    @Override
    public String getNombre() {
        return "Reportes Regulatorios";
    }

    @Override
    public void procesar(CambioRiesgo cambio) {

        System.out.println(
                "Reportes Regulatorios: generando reporte del cliente " +
                cambio.getIdCliente()
        );

        System.out.println(
                "Cambio registrado: " +
                cambio.getPerfilAnterior() + " -> " +
                cambio.getPerfilNuevo()
        );
    }
}
