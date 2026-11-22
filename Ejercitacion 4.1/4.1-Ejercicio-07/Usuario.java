public class Usuario implements Observador {

    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Noticia noticia) {
        System.out.println("\nAVISO PARA: " + nombre);
        System.out.println("Nueva noticia: " + noticia.getTitulo());
        System.out.println("Categoría: " + noticia.getCategoria());
        System.out.println("Contenido: " + noticia.getContenido());
        System.out.println("-----------------------------");
    }
}
