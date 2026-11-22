public class Main {

    public static void main(String[] args) {

        Tarea tarea = new Tarea("Desarrollar módulo de usuarios");

        ObservadorTarea correo = new NotificadorCorreo();
        ObservadorTarea estadisticas = new ModuloEstadisticas();

        // Registrar observadores
        tarea.suscribir(correo);
        tarea.suscribir(estadisticas);

        // Cambiar el estado de la tarea
        tarea.cambiarEstado(EstadoTarea.EN_PROGRESO);

        System.out.println("-------------------------");

        tarea.cambiarEstado(EstadoTarea.COMPLETADA);

        // Eliminar un observador
        tarea.desuscribir(correo);

        System.out.println("-------------------------");

        tarea.cambiarEstado(EstadoTarea.PENDIENTE);
    }
}
