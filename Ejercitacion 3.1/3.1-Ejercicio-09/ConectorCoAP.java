public class ConectorCoAP extends ConectorBase {

    public ConectorCoAP(ConfiguracionIoT configuracion,
                        MetricasConexion metricas) {

        super(configuracion, metricas);
    }

    @Override
    protected void iniciarCanal() throws Exception {

        System.out.println(
            "Inicializando canal CoAP en "
            + configuracion.getServidor()
        );
    }

    @Override
    public String getProtocolo() {
        return "CoAP";
    }
}
