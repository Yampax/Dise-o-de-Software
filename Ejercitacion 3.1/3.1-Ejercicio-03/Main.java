public class Main {

    public static void main(String[] args) {

        CreadorNotificacion creador;

        // Enviar notificación por correo
        creador = new CreadorEmail();
        creador.enviarNotificacion("Su cuenta fue creada correctamente.");

        // Enviar notificación por SMS
        creador = new CreadorSMS();
        creador.enviarNotificacion("Su turno fue confirmado.");
    }
}
