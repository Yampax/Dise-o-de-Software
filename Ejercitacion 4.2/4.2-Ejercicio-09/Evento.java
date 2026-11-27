public class Evento {

    private String tipo;
    private String severidad;
    private String descripcion;

    public Evento(String tipo, String severidad, String descripcion) {
        this.tipo = tipo;
        this.severidad = severidad;
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public String getSeveridad() {
        return severidad;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
