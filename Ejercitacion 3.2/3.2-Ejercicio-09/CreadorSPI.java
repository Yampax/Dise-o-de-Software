public class CreadorSPI extends CreadorConector {

    @Override
    protected ConectorSensor crearConector() {
        return new ConectorSPI();
    }
}
