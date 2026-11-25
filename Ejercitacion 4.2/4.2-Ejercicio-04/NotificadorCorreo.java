public class NotificadorCorreo implements ObservadorPrecio {

    @Override
    public void actualizar(String nombreProducto,
                           double precioAnterior,
                           double precioNuevo,
                           double porcentajeRebaja) {

        System.out.println("\n[CORREO ELECTRÓNICO]");

        System.out.println(
            "El producto " + nombreProducto + " bajó de precio."
        );

        System.out.println("Precio anterior: $" + precioAnterior);
        System.out.println("Precio actual: $" + precioNuevo);

        System.out.printf(
            "Descuento disponible: %.2f%%%n",
            porcentajeRebaja
        );
    }
}
