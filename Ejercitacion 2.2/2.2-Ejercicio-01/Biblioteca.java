public class Biblioteca {

    private static Biblioteca instancia = null;

    private String nombreBiblioteca;
    private int maxLibrosPorSocio;
    private int plazoDevolucion;

    private Biblioteca() {
        nombreBiblioteca = "Biblioteca Central";
        maxLibrosPorSocio = 5;
        plazoDevolucion = 15;
    }

    public static synchronized Biblioteca getInstancia() {
        if (instancia == null) {
            instancia = new Biblioteca();
        }
        return instancia;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        if (nombreBiblioteca == null || nombreBiblioteca.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre de la biblioteca no puede estar vacío.");
        }
        this.nombreBiblioteca = nombreBiblioteca;
    }

    public int getMaxLibrosPorSocio() {
        return maxLibrosPorSocio;
    }

    public void setMaxLibrosPorSocio(int maxLibrosPorSocio) {
        if (maxLibrosPorSocio <= 0) {
            throw new IllegalArgumentException(
                    "El máximo de libros debe ser mayor que cero.");
        }
        this.maxLibrosPorSocio = maxLibrosPorSocio;
    }

    public int getPlazoDevolucion() {
        return plazoDevolucion;
    }

    public void setPlazoDevolucion(int plazoDevolucion) {
        if (plazoDevolucion <= 0) {
            throw new IllegalArgumentException(
                    "El plazo de devolución debe ser mayor que cero.");
        }
        this.plazoDevolucion = plazoDevolucion;
    }
}
