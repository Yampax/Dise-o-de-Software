public class CreadorNube extends CreadorAlmacenamiento {

    @Override
    public Almacenamiento crearAlmacenamiento() {
        return new AlmacenamientoNube();
    }
}
