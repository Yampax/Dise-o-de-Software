import java.time.LocalDateTime;

public class ResultadoNotificacion {

    private final String observador;
    private final boolean exitoso;
    private final String detalle;
    private final LocalDateTime fecha;

    public ResultadoNotificacion(String observador,
                                 boolean exitoso,
                                 String detalle) {

        this.observador = observador;
        this.exitoso = exitoso;
        this.detalle = detalle;
        this.fecha = LocalDateTime.now();
    }

    public String getObservador() {
        return observador;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public String getDetalle() {
        return detalle;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {

        String estado = exitoso ? "EXITOSO" : "ERROR";

        return "[" + estado + "] " + observador
                + " - " + detalle
                + " - " + fecha;
    }
}
