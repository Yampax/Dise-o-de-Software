public class ExcepcionConexion extends Exception {

    public ExcepcionConexion(String mensaje) {
        super(mensaje);
    }

    public ExcepcionConexion(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
