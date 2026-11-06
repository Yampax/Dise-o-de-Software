public class SolicitudFiscal {

    private final String pais;
    private final DatosEmisor emisor;
    private final DatosReceptor receptor;
    private final DatosTributarios datos;

    public SolicitudFiscal(String pais,
                           DatosEmisor emisor,
                           DatosReceptor receptor,
                           DatosTributarios datos) {

        this.pais = pais;
        this.emisor = emisor;
        this.receptor = receptor;
        this.datos = datos;
    }

    public String getPais() {
        return pais;
    }

    public DatosEmisor getEmisor() {
        return emisor;
    }

    public DatosReceptor getReceptor() {
        return receptor;
    }

    public DatosTributarios getDatos() {
        return datos;
    }
}
