public class Main {

    public static void main(String[] args) {

        // Crear producto
        Producto producto = new Producto(
            "Auriculares Bluetooth",
            100000
        );

        // Crear observadores
        NotificadorCorreo correo = new NotificadorCorreo();

        PanelNotificaciones panel = new PanelNotificaciones();

        // Suscribir los canales al producto
        producto.suscribir(correo);
        producto.suscribir(panel);

        // Primera actualización: hay una rebaja del 20%
        producto.actualizarPrecio(80000);

        // Segunda actualización: el precio aumenta
        producto.actualizarPrecio(90000);

        // Tercera actualización: hay otra rebaja
        producto.actualizarPrecio(70000);

        // Desuscribir el correo
        producto.desuscribir(correo);

        System.out.println("\nSe desuscribió el correo electrónico.");

        // Solamente el panel recibe la notificación
        producto.actualizarPrecio(60000);
    }
}
