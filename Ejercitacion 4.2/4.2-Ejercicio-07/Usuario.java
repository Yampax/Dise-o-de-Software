public class Usuario implements ObservadorVideo {

    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(Video video) {

        System.out.println("\n[NOTIFICACIÓN EMERGENTE]");

        System.out.println(
            "Hola " + nombre + ", hay un nuevo video disponible."
        );

        System.out.println(
            "Canal: " + video.getNombreCanal()
        );

        System.out.println(
            "Título: " + video.getTitulo()
        );

        System.out.println(
            "Descripción: " + video.getDescripcion()
        );

        System.out.println("--------------------------------");
    }
}
