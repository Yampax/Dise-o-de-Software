import java.time.LocalDateTime;

public class Reserva {

    private final String idSocio;
    private final LocalDateTime fecha;

    public Reserva(String idSocio) {
        this.idSocio = idSocio;
        this.fecha = LocalDateTime.now();
    }

    public String getIdSocio() {
        return idSocio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Socio: " + idSocio + " | Fecha: " + fecha;
    }
}

