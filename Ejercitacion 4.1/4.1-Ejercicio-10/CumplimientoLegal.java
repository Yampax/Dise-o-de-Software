public class CumplimientoLegal implements ObservadorRegulatorio {

    @Override
    public String getNombre() {
        return "Cumplimiento Legal";
    }

    @Override
    public void procesar(CambioRiesgo cambio) {

        System.out.println(
                "Cumplimiento Legal: verificando cambio del cliente " +
                cambio.getIdCliente()
        );
    }
}
