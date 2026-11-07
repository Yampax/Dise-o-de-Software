public class CreadorLocal extends CreadorAlmacenamiento {

    @Override
    public Almacenamiento crearAlmacenamiento() {
        return new AlmacenamientoLocal();
    }
}
