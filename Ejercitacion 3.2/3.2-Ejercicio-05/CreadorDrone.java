public class CreadorDrone extends CreadorEnemigo {

    @Override
    public Enemigo crearEnemigo() {
        return new DroneCombate();
    }
}
