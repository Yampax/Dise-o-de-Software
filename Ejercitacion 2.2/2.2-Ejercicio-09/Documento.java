public class Documento {

    private final String identificador;
    private final String nombre;
    private final String sector;
    private final int cantidadPaginas;

    public Documento(String identificador, String nombre,
                     String sector, int cantidadPaginas) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.sector = sector;
        this.cantidadPaginas = cantidadPaginas;
    }

    public String getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSector() {
        return sector;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    @Override
    public String toString() {
        return "ID: " + identificador +
                " | Documento: " + nombre +
                " | Sector: " + sector +
                " | Páginas: " + cantidadPaginas;
    }
}

