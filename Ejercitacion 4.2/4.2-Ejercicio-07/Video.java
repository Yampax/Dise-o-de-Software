public class Video {

    private final String idCanal;
    private final String nombreCanal;
    private final String titulo;
    private final String descripcion;

    public Video(String idCanal,
                 String nombreCanal,
                 String titulo,
                 String descripcion) {

        this.idCanal = idCanal;
        this.nombreCanal = nombreCanal;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getIdCanal() {
        return idCanal;
    }

    public String getNombreCanal() {
        return nombreCanal;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
