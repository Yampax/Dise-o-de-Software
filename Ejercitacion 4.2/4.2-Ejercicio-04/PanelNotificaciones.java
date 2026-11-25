public class PanelNotificaciones implements ObservadorPrecio {

    @Override
    public void actualizar(String nombreProducto,
                           double precioAnterior,
                           double precioNuevo,
                           double porcentajeRebaja) {

        System.out.println("\n[PANEL DE NOTIFICACIONES]");

        System.out.println(
            "¡El producto " + nombreProducto + " está más barato!"
        );

        System.out.println("Nuevo precio: $" + precioNuevo);

        System.out.printf(
            "Ahorrás un %.2f%%%n",
            porcentajeRebaja
        );
    }
}
