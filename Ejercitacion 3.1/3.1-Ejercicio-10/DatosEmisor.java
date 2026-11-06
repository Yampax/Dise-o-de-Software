public class DatosEmisor {

    private final String razonSocial;
    private final String identificadorFiscal;
    private final String domicilio;

    public DatosEmisor(String razonSocial,
                       String identificadorFiscal,
                       String domicilio) {

        this.razonSocial = razonSocial;
        this.identificadorFiscal = identificadorFiscal;
        this.domicilio = domicilio;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public String getIdentificadorFiscal() {
        return identificadorFiscal;
    }

    public String getDomicilio() {
        return domicilio;
    }
}
