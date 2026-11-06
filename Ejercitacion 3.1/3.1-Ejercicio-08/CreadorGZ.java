public class CreadorGZ extends CreadorCompresor {

    @Override
    protected Compresor crearCompresor() {

        return new CompresorGZ();
    }
}
