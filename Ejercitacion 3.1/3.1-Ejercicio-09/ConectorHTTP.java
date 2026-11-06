public class ConectorHTTP extends ConectorBase {

    public ConectorHTTP(ConfiguracionIoT configuracion,
                        MetricasConexion metricas) {

        super(configuracion, metricas);
    }

    @Override
    protected void iniciarCanal() throws Exception {

        System.out.println(
            "Inicializando canal HTTP en "
            + configuracion.getServidor()
        );
    }

    @Override
    public String getProtocolo() {
        return "HTTP";
    }
}
