public class Main {

    public static void main(String[] args) {

        FabricaPersonajes fabrica = new FabricaPersonajes();

        Personaje guerrero =
            fabrica.crearPersonaje("guerrero", "Arthas");

        Personaje mago =
            fabrica.crearPersonaje("mago", "Merlín");

        Personaje arquero =
            fabrica.crearPersonaje("arquero", "Legolas");

        guerrero.mostrarEstadisticas();
        mago.mostrarEstadisticas();
        arquero.mostrarEstadisticas();
    }
}
