import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class RegistroInsumos {

    private static RegistroInsumos instancia = null;

    private List<Movimiento> movimientos;

    private RegistroInsumos() {
        movimientos = new ArrayList<>();
    }

    public static synchronized RegistroInsumos getInstancia() {
        if (instancia == null) {
            instancia = new RegistroInsumos();
        }
        return instancia;
    }

    public boolean registrarMovimiento(String codigoInsumo,
                                       String tipo,
                                       int cantidad,
                                       String sector) {

        if (codigoInsumo == null || codigoInsumo.isBlank()
                || sector == null || sector.isBlank()
                || cantidad <= 0) {
            return false;
        }

        if (!tipo.equalsIgnoreCase("ENTRADA")
                && !tipo.equalsIgnoreCase("SALIDA")) {
            return false;
        }

        int saldoActual = consultarSaldo(codigoInsumo);

        if (tipo.equalsIgnoreCase("SALIDA")
                && cantidad > saldoActual) {
            return false;
        }

        Movimiento movimiento = new Movimiento(
                codigoInsumo,
                tipo.toUpperCase(),
                cantidad,
                sector
        );

        movimientos.add(movimiento);

        return true;
    }

    public List<Movimiento> obtenerHistorial() {
        return Collections.unmodifiableList(
                new ArrayList<>(movimientos)
        );
    }

    public List<Movimiento> filtrarPorInsumo(String codigoInsumo) {

        List<Movimiento> resultado = new ArrayList<>();

        for (Movimiento movimiento : movimientos) {
            if (movimiento.getCodigoInsumo()
                    .equalsIgnoreCase(codigoInsumo)) {
                resultado.add(movimiento);
            }
        }

        return Collections.unmodifiableList(resultado);
    }

    public List<Movimiento> filtrarPorSector(String sector) {

        List<Movimiento> resultado = new ArrayList<>();

        for (Movimiento movimiento : movimientos) {
            if (movimiento.getSector().equalsIgnoreCase(sector)) {
                resultado.add(movimiento);
            }
        }

        return Collections.unmodifiableList(resultado);
    }

    public int consultarSaldo(String codigoInsumo) {

        int saldo = 0;

        for (Movimiento movimiento : movimientos) {

            if (movimiento.getCodigoInsumo()
                    .equalsIgnoreCase(codigoInsumo)) {

                if (movimiento.getTipo().equals("ENTRADA")) {
                    saldo += movimiento.getCantidad();
                } else {
                    saldo -= movimiento.getCantidad();
                }
            }
        }

        return saldo;
    }
}
