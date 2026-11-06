public class CreadorTAR extends CreadorCompresor {

    @Override
    protected Compresor crearCompresor() {

        return new CompresorTAR();
    }
}
