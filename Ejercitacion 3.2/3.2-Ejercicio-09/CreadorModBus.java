public class CreadorModBus extends CreadorConector {

    @Override
    protected ConectorSensor crearConector() {
        return new ConectorModBus();
    }
}
