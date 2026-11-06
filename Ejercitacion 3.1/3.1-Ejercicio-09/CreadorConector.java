public abstract class CreadorConector {

    protected abstract ConectorIoT crearConector(
        ConfiguracionIoT configuracion,
        MetricasConexion metricas
    ) throws ExcepcionConexion;

    public final ConectorIoT inicializar(
        ConfiguracionIoT configuracion
    ) throws ExcepcionConexion {

        validarConfiguracion(configuracion);

        MetricasConexion metricas =
            new MetricasConexion(obtenerProtocolo());

        ConectorIoT conector =
            crearConector(configuracion, metricas);

        conector.conectar();

        return conector;
    }

    protected abstract String obtenerProtocolo();

    private void validarConfiguracion(
        ConfiguracionIoT configuracion
    ) throws ExcepcionConexion {

        if (configuracion == null) {
            throw new ExcepcionConexion(
                "La configuración no puede ser nula."
            );
        }

        if (configuracion.getServidor() == null
                || configuracion.getServidor().isBlank()) {

            throw new ExcepcionConexion(
                "Debe especificarse un servidor."
            );
        }

        if (configuracion.getPuerto() < 1
                || configuracion.getPuerto() > 65535) {

            throw new ExcepcionConexion(
                "El puerto especificado no es válido."
            );
        }

        if (configuracion.getUsuario() == null
                || configuracion.getUsuario().isBlank()
                || configuracion.getContrasena() == null
                || configuracion.getContrasena().isBlank()) {

            throw new ExcepcionConexion(
                "Las credenciales son obligatorias."
            );
        }

        if (!configuracion.isConexionSegura()) {

            throw new ExcepcionConexion(
                "La conexión debe utilizar un canal seguro."
            );
        }
    }
}
