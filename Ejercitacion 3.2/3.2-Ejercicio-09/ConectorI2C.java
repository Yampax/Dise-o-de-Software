public class ConectorI2C extends ConectorBase {

    @Override
    protected void validarConfiguracion(ConfiguracionSensor config)
            throws Exception {

        if (config == null || config.getDireccion() == null
                || !config.getDireccion().matches("0x[0-9A-Fa-f]+")) {
            throw new Exception("Dirección I2C inválida.");
        }

        int direccion = Integer.parseInt(
                config.getDireccion().substring(2), 16);

        if (direccion < 0x03 || direccion > 0x77) {
            throw new Exception("Dirección I2C fuera de rango.");
        }

        if (config.getFrecuencia() <= 0) {
            throw new Exception("Frecuencia I2C inválida.");
        }
    }

    @Override
    protected void abrirPuerto(ConfiguracionSensor config)
            throws Exception {

        System.out.println("Inicializando puerto I2C...");
    }

    @Override
    protected String realizarLectura() {
        return "Humedad: 60 % (I2C)";
    }
}
