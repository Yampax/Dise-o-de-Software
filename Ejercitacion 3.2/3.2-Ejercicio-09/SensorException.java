public class SensorException extends Exception {

    public SensorException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }

    public SensorException(String mensaje) {
        super(mensaje);
    }
}
