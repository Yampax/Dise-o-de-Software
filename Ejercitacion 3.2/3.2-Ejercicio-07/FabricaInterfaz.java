public class FabricaInterfaz {

    public static InterfazGrafica crear(TipoPantalla tipo) {

        CreadorInterfaz creador;

        switch (tipo) {
            case ESCRITORIO:
                creador = new CreadorEscritorio();
                break;

            case MOVIL:
                creador = new CreadorMovil();
                break;

            default:
                throw new IllegalArgumentException(
                        "Modo de pantalla desconocido");
        }

        return creador.crearInterfaz();
    }
}
