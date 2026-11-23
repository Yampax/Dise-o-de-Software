import java.time.LocalDateTime;

public class CambioRiesgo {

    private final int idCliente;
    private final PerfilRiesgo perfilAnterior;
    private final PerfilRiesgo perfilNuevo;
    private final LocalDateTime fecha;

    public CambioRiesgo(int idCliente,
                        PerfilRiesgo perfilAnterior,
                        PerfilRiesgo perfilNuevo) {

        this.idCliente = idCliente;
        this.perfilAnterior = perfilAnterior;
        this.perfilNuevo = perfilNuevo;
        this.fecha = LocalDateTime.now();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public PerfilRiesgo getPerfilAnterior() {
        return perfilAnterior;
    }

    public PerfilRiesgo getPerfilNuevo() {
        return perfilNuevo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }
}
