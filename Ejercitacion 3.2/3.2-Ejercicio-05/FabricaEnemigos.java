public class FabricaEnemigos {

    public static Enemigo crear(TipoEnemigo tipo) {

        CreadorEnemigo creador;

        switch (tipo) {
            case SOLDADO:
                creador = new CreadorSoldado();
                break;

            case DRONE:
                creador = new CreadorDrone();
                break;

            default:
                throw new IllegalArgumentException("Tipo de enemigo desconocido");
        }

        return creador.crearEnemigo();
    }
}
