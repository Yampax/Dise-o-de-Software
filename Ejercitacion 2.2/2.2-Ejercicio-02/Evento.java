import java.time.LocalDateTime;
public class Evento {

    private final LocalDateTime fechaHora;
    private final String sector;
    private final String descripcion;

    public Evento(String sector, String descripcion) {
        if (sector == null || sector.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El sector no puede estar vacío.");
        }

        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La descripción no puede estar vacía.");
        }

        this.fechaHora = LocalDateTime.now();
        this.sector = sector;
        this.descripcion = descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getSector() {
        return sector;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return fechaHora + " | Sector: " + sector
                + " | Actividad: " + descripcion;
    }
}

