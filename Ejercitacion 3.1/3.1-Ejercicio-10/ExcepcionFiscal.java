public class ExcepcionFiscal extends Exception {

    public ExcepcionFiscal(String mensaje) {
        super(mensaje);
    }

    public ExcepcionFiscal(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
