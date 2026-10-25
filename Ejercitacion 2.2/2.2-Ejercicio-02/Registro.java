import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Registro {

    private static Registro instancia = null;

    private final List<Evento> eventos;

    private Registro() {
        eventos = new ArrayList<>();
    }

    public static synchronized Registro getInstancia() {
        if (instancia == null) {
            instancia = new Registro();
        }
        return instancia;
    }

    public synchronized void registrarActividad(
            String sector, String descripcion) {

        Evento evento = new Evento(sector, descripcion);
        eventos.add(evento);
    }

    public synchronized List<Evento> obtenerHistorial() {
        return Collections.unmodifiableList(
                new ArrayList<>(eventos));
    }

    public synchronized List<Evento> filtrarPorSector(String sector) {
        List<Evento> resultado = new ArrayList<>();

        for (Evento evento : eventos) {
            if (evento.getSector().equalsIgnoreCase(sector)) {
                resultado.add(evento);
            }
        }

        return Collections.unmodifiableList(resultado);
    }

    public synchronized int cantidadEventos() {
        return eventos.size();
    }
}

