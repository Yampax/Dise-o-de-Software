public class NotificadorCorreo implements ObservadorTarea {

    @Override
    public void actualizar(String nombreTarea,
                           EstadoTarea estadoAnterior,
                           EstadoTarea estadoNuevo) {

        System.out.println(
                "Correo enviado: La tarea '" + nombreTarea +
                "' cambió de " + estadoAnterior +
                " a " + estadoNuevo
        );
    }
}
