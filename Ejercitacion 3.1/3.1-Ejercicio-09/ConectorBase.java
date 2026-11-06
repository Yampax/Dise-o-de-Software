public abstract class ConectorBase implements ConectorIoT {

    protected ConfiguracionIoT configuracion;
    protected MetricasConexion metricas;

    protected EstadoConexion estado;

    public ConectorBase(ConfiguracionIoT configuracion,
                        MetricasConexion metricas) {

        this.configuracion = configuracion;
        this.metricas = metricas;
        this.estado = EstadoConexion.DESCONECTADO;
    }

    protected abstract void iniciarCanal() throws Exception;

    @Override
    public void conectar() throws ExcepcionConexion {

        estado = EstadoConexion.CONECTANDO;
        metricas.actualizarEstado(estado);

        try {

            iniciarCanal();

            estado = EstadoConexion.CONECTADO;
            metricas.actualizarEstado(estado);
            metricas.registrarConexion();

            System.out.println(
                getProtocolo() + " conectado correctamente."
            );

        } catch (Exception e) {

            estado = EstadoConexion.ERROR;
            metricas.actualizarEstado(estado);
            metricas.registrarError();

            throw new ExcepcionConexion(
                "No se pudo inicializar el protocolo "
                + getProtocolo(), e
            );
        }
    }

    @Override
    public void desconectar() {

        estado = EstadoConexion.DESCONECTADO;
        metricas.actualizarEstado(estado);

        System.out.println(
            getProtocolo() + " desconectado."
        );
    }

    @Override
    public void reconectar() throws ExcepcionConexion {

        metricas.registrarReconectar();

        desconectar();

        System.out.println(
            "Intentando reconectar mediante " + getProtocolo()
        );

        conectar();
    }

    @Override
    public EstadoConexion getEstado() {
        return estado;
    }
}
