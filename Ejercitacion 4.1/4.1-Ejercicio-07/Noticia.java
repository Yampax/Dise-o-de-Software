public class Noticia {

    private String titulo;
    private String contenido;
    private String categoria;

    public Noticia(String titulo, String contenido, String categoria) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getCategoria() {
        return categoria;
    }
}
