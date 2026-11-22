public class Main {

    public static void main(String[] args) throws InterruptedException {

        BusEventos bus = new BusEventos();

        // Crear observadores
        ServicioNotificaciones notificaciones =
                new ServicioNotificaciones();

        ServicioEstadisticas estadisticas =
                new ServicioEstadisticas();

        ObservadorDefectuoso defectuoso =
                new ObservadorDefectuoso();

        // Suscribir observadores a eventos específicos
        bus.suscribir("UsuarioRegistrado", notificaciones);
        bus.suscribir("UsuarioRegistrado", estadisticas);
        bus.suscribir("UsuarioRegistrado", defectuoso);

        bus.suscribir("PagoAprobado", notificaciones);
        bus.suscribir("PagoAprobado", estadisticas);

        // Crear servicios publicadores
        ServicioUsuarios usuarios = new ServicioUsuarios(bus);
        ServicioPagos pagos = new ServicioPagos(bus);

        // Publicar eventos
        usuarios.registrarUsuario(
                "Carlos",
                "carlos@gmail.com"
        );

        pagos.aprobarPago(101, 25000);

        // Dar tiempo para que finalice la simulación
        Thread.sleep(1000);

        // Cerrar el bus
        bus.cerrar();
    }
}
