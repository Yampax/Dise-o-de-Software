import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestorReserva {

    private static GestorReserva instancia = null;

    private final int capacidad = 10;
    private final List<Reserva> reservas;

    private GestorReserva() {
        reservas = new ArrayList<>();
    }

    public static synchronized GestorReserva getInstancia() {
        if (instancia == null) {
            instancia = new GestorReserva();
        }
        return instancia;
    }

    public synchronized boolean reservar(String idSocio) {

        if (idSocio == null || idSocio.trim().isEmpty()) {
            return false;
        }

        // Comprobar si el socio ya tiene una reserva
        for (Reserva reserva : reservas) {
            if (reserva.getIdSocio().equalsIgnoreCase(idSocio)) {
                return false;
            }
        }

        // Comprobar si quedan lugares disponibles
        if (reservas.size() >= capacidad) {
            return false;
        }

        // Registrar la reserva
        reservas.add(new Reserva(idSocio));
        return true;
    }

    public synchronized boolean cancelar(String idSocio) {

        for (Reserva reserva : reservas) {
            if (reserva.getIdSocio().equalsIgnoreCase(idSocio)) {
                reservas.remove(reserva);
                return true;
            }
        }

        return false;
    }

    public synchronized List<Reserva> obtenerReservas() {
        return Collections.unmodifiableList(
                new ArrayList<>(reservas));
    }

    public synchronized int lugaresDisponibles() {
        return capacidad - reservas.size();
    }
}

