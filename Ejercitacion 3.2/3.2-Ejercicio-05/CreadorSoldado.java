public class CreadorSoldado extends CreadorEnemigo {

    @Override
    public Enemigo crearEnemigo() {
        return new SoldadoRaso();
    }
}
