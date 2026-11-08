public class ConectorSPI extends ConectorBase {

    @Override
    protected void validarConfiguracion(ConfiguracionSensor config)
            throws Exception {

        if (config == null || config.getDireccion() == null
                || config.getDireccion().isBlank()) {
            throw new Exception("Dirección SPI inválida.");
        }

        if (config.getCanal() < 0 || config.getFrecuencia() <= 0) {
            throw new Exception("Parámetros SPI incorrectos.");
        }
    }

    @Override
    protected void abrirPuerto(ConfiguracionSensor config)
            throws Exception {

        System.out.println("Inicializando puerto SPI...");
    }

    @Override
    protected String realizarLectura() {
        return "Presión: 1013 hPa (SPI)";
    }
}
