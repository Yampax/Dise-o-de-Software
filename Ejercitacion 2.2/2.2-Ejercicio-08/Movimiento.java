import java.time.LocalDateTime;
public class Movimiento {

    private final String codigoInsumo;
    private final String tipo;
    private final int cantidad;
    private final String sector;
    private final LocalDateTime fecha;

    public Movimiento(String codigoInsumo, String tipo,
                      int cantidad, String sector) {
        this.codigoInsumo = codigoInsumo;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.sector = sector;
        this.fecha = LocalDateTime.now();
    }

    public String getCodigoInsumo() {
        return codigoInsumo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getSector() {
        return sector;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "Insumo: " + codigoInsumo +
                " | Tipo: " + tipo +
                " | Cantidad: " + cantidad +
                " | Sector: " + sector +
                " | Fecha: " + fecha;
    }
}

