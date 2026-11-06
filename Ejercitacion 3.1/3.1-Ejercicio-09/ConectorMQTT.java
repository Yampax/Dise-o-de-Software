public class ConectorMQTT extends ConectorBase {

    public ConectorMQTT(ConfiguracionIoT configuracion,
                        MetricasConexion metricas) {

        super(configuracion, metricas);
    }

    @Override
    protected void iniciarCanal() throws Exception {

        System.out.println(
            "Inicializando canal MQTT en "
            + configuracion.getServidor()
        );
    }

    @Override
    public String getProtocolo() {
        return "MQTT";
    }
}
