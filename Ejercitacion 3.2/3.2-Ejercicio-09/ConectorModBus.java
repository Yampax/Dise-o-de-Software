public class ConectorModBus extends ConectorBase {

    @Override
    protected void validarConfiguracion(ConfiguracionSensor config)
            throws Exception {

        if (config == null || config.getDireccion() == null
                || !config.getDireccion().matches("\\d+")) {
            throw new Exception("Dirección ModBus inválida.");
        }

        if (config.getCanal() <= 0 || config.getFrecuencia() <= 0) {
            throw new Exception("Parámetros ModBus incorrectos.");
        }
    }

    @Override
    protected void abrirPuerto(ConfiguracionSensor config)
            throws Exception {

        System.out.println("Inicializando puerto ModBus...");
    }

    @Override
    protected String realizarLectura() {
        return "Temperatura: 25 °C (ModBus)";
    }
}
