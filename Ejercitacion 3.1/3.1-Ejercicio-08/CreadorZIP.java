public class CreadorZIP extends CreadorCompresor {

    @Override
    protected Compresor crearCompresor() {

        return new CompresorZIP();
    }
}
