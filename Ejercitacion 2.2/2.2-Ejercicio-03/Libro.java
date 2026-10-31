public class Libro {
    private final String codigo;
    private final String titulo;
    private final String autor;
    private int cantidadEjemplares;

    public Libro (String codigo, String titulo, String autor, int cantidadEjemplares){
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadEjemplares = cantidadEjemplares;
    }

    public String getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public int getCantidadEjemplares() {
        return cantidadEjemplares;
    }

    public void setCantidadEjemplares(int cantidadEjemplares){
        this.cantidadEjemplares = cantidadEjemplares;
    }

    @Override
    public String toString(){
        return "Código: " + codigo
                + " | Título: " + titulo
                + " | Autor: " + autor
                + " | Ejemplares: " + cantidadEjemplares;
    }
}
