public class Main {

    public static void main(String[] args) {

        DatosEnvio pedido = new DatosEnvio(
                5,
                200,
                "Mendoza",
                "Junín",
                true
        );

        // Solicitar envío postal
        ServicioEnvio postal = FabricaEnvios.crearServicio(
                TipoEnvio.POSTAL, pedido);

        postal.mostrarInformacion(pedido);

        System.out.println();

        // Solicitar envío expreso
        ServicioEnvio expreso = FabricaEnvios.crearServicio(
                TipoEnvio.EXPRESO, pedido);

        expreso.mostrarInformacion(pedido);

        System.out.println();

        // Solicitar retiro en sucursal
        ServicioEnvio sucursal = FabricaEnvios.crearServicio(
                TipoEnvio.SUCURSAL, pedido);

        sucursal.mostrarInformacion(pedido);
    }
}
