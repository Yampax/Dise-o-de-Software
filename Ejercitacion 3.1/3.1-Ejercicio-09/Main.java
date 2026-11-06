public class Main {

    public static void main(String[] args) {

        RegistroFactorias registro =
            new RegistroFactorias();

        // Registro de las factorías disponibles
        registro.registrar("MQTT", new CreadorMQTT());
        registro.registrar("HTTP", new CreadorHTTP());
        registro.registrar("CoAP", new CreadorCoAP());

        // Configuración del sensor
        ConfiguracionIoT configuracion =
            new ConfiguracionIoT(
                "servidor-industrial.com",
                8883,
                "sensor01",
                "claveSegura123",
                true
            );

        try {

            // Creación del conector MQTT
            ConectorIoT conector =
                registro.crear("MQTT", configuracion);

            System.out.println(
                "\nEstado actual: " + conector.getEstado()
            );

            // Simulación de una reconexión
            System.out.println("\n--- RECONEXIÓN ---");

            conector.reconectar();

            // Desconexión
            System.out.println("\n--- DESCONEXIÓN ---");

            conector.desconectar();

        } catch (ExcepcionConexion e) {

            System.out.println(
                "Error de conexión: " + e.getMessage()
            );
        }
    }
}
