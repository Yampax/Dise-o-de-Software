public class Main {

    public static void main(String[] args) {

        RegistroFactorias registro = new RegistroFactorias();
        RegistroMetricas metricas = new RegistroMetricas();

        // Registro inicial de factorías.
        registro.registrar("MODBUS", new CreadorModBus());
        registro.registrar("I2C", new CreadorI2C());
        registro.registrar("SPI", new CreadorSPI());

        GestorSensores gestor = new GestorSensores(registro, metricas);

        try {
            ConfiguracionSensor configModBus =
                    new ConfiguracionSensor("1", 1, 9600);

            ConfiguracionSensor configI2C =
                    new ConfiguracionSensor("0x48", 1, 100000);

            ConfiguracionSensor configSPI =
                    new ConfiguracionSensor("SPI-1", 0, 1000000);

            gestor.conectarSensor(
                    "SENSOR-01", "MODBUS", configModBus);

            gestor.conectarSensor(
                    "SENSOR-02", "I2C", configI2C);

            gestor.conectarSensor(
                    "SENSOR-03", "SPI", configSPI);

            System.out.println("\n=== LECTURAS ===");

            gestor.leerSensor("SENSOR-01");
            gestor.leerSensor("SENSOR-02");
            gestor.leerSensor("SENSOR-03");

        } catch (SensorException | IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }

        gestor.mostrarMetricas();

        gestor.desconectarSensor("SENSOR-01");
        gestor.desconectarSensor("SENSOR-02");
        gestor.desconectarSensor("SENSOR-03");
    }
}
