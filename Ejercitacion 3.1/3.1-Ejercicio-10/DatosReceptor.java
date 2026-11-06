public class DatosReceptor {

    private final String nombre;
    private final String identificadorFiscal;

    public DatosReceptor(String nombre,
                         String identificadorFiscal) {

        this.nombre = nombre;
        this.identificadorFiscal = identificadorFiscal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdentificadorFiscal() {
        return identificadorFiscal;
    }
}
