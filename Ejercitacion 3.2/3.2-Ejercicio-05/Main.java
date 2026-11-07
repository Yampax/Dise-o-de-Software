public class Main {

    public static void main(String[] args) {

        Enemigo soldado = FabricaEnemigos.crear(TipoEnemigo.SOLDADO);
        Enemigo drone = FabricaEnemigos.crear(TipoEnemigo.DRONE);

        soldado.mostrarInformacion();

        System.out.println();

        drone.mostrarInformacion();
    }
}
