public class CreadorI2C extends CreadorConector {

    @Override
    protected ConectorSensor crearConector() {
        return new ConectorI2C();
    }
}
