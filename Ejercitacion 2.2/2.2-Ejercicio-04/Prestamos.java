import java.time.LocalDate;

public class Prestamos {

    private final String idEjemplar;
    private final String socio;
    private final LocalDate fecha;

    public Prestamos (String idEjemplar, String socio) {
        this.idEjemplar = idEjemplar;
        this.socio = socio;
        this.fecha = LocalDate.now();
    }

    public String getIdEjemplar() {
        return idEjemplar;
    }

    public String getSocio() {
        return socio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Ejemplar: " + idEjemplar
                + " | Socio: " + socio
                + " | Fecha: " + fecha;
    }
}

