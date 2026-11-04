public abstract class CreadorNotificacion {

    public abstract Notificacion crearNotificacion();

    public void enviarNotificacion(String mensaje) {

        Notificacion notificacion = crearNotificacion();

        notificacion.enviar(mensaje);
    }
}
