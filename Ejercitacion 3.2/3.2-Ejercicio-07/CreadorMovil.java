public class CreadorMovil extends CreadorInterfaz {

    @Override
    public InterfazGrafica crearInterfaz() {
        return new InterfazMovil();
    }
}
