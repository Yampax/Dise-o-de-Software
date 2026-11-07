public class CreadorEscritorio extends CreadorInterfaz {

    @Override
    public InterfazGrafica crearInterfaz() {
        return new InterfazEscritorio();
    }
}
