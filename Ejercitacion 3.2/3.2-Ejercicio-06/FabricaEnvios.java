public class FabricaEnvios {

    public static ServicioEnvio crearServicio(
            TipoEnvio tipo, DatosEnvio datos) {

        if (datos == null) {
            throw new IllegalArgumentException(
                    "Los datos del envío son obligatorios");
        }

        if (datos.getPeso() <= 0 || datos.getDistancia() < 0
                || datos.getProvincia() == null
                || datos.getLocalidad() == null
                || datos.getProvincia().isBlank()
                || datos.getLocalidad().isBlank()) {
            throw new IllegalArgumentException(
                    "Los datos del destino o del pedido son inválidos");
        }

        CreadorEnvio creador;

        switch (tipo) {
            case POSTAL:
                creador = new CreadorPostal();
                break;

            case EXPRESO:
                if (datos.getDistancia() > 500) {
                    throw new IllegalArgumentException(
                            "El envío expreso no está disponible "
                                    + "para distancias mayores a 500 km");
                }
                creador = new CreadorExpreso();
                break;

            case SUCURSAL:
                if (!datos.isSucursalDisponible()) {
                    throw new IllegalArgumentException(
                            "No hay sucursales disponibles en el destino");
                }
                creador = new CreadorSucursal();
                break;

            default:
                throw new IllegalArgumentException(
                        "Tipo de envío desconocido");
        }

        return creador.crearServicio();
    }
}
