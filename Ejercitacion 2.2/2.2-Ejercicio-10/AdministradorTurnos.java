import java.time.LocalDate;
import java.util.*;
public class AdministradorTurnos {

    private static AdministradorTurnos instancia = null;

    private Map<String, Set<String>> agenda;
    private List<Turno> turnos;

    private AdministradorTurnos() {
        agenda = new HashMap<>();
        turnos = new ArrayList<>();
    }

    public static synchronized AdministradorTurnos getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorTurnos();
        }
        return instancia;
    }

    // Cargar horarios disponibles
    public synchronized void cargarAgenda(
            String profesional,
            LocalDate fecha,
            String[] horarios) {

        String clave = profesional + "-" + fecha;

        Set<String> disponibles = new HashSet<>();

        for (String horario : horarios) {
            disponibles.add(horario);
        }

        agenda.put(clave, disponibles);
    }

    // Reservar un turno
    public synchronized boolean reservarTurno(
            String paciente,
            String profesional,
            LocalDate fecha,
            String horario) {

        String clave = profesional + "-" + fecha;

        Set<String> disponibles = agenda.get(clave);

        if (disponibles == null
                || !disponibles.contains(horario)) {
            return false;
        }

        Turno nuevoTurno = new Turno(
                paciente, profesional, fecha, horario
        );

        disponibles.remove(horario);
        turnos.add(nuevoTurno);

        return true;
    }

    // Cancelar un turno
    public synchronized boolean cancelarTurno(
            String paciente,
            String profesional,
            LocalDate fecha,
            String horario) {

        Iterator<Turno> iterador = turnos.iterator();

        while (iterador.hasNext()) {

            Turno turno = iterador.next();

            if (turno.getPaciente().equalsIgnoreCase(paciente)
                    && turno.getProfesional().equalsIgnoreCase(profesional)
                    && turno.getFecha().equals(fecha)
                    && turno.getHorario().equals(horario)) {

                String clave = profesional + "-" + fecha;

                agenda.get(clave).add(horario);
                iterador.remove();

                return true;
            }
        }

        return false;
    }

    // Consultar horarios disponibles
    public synchronized Set<String> consultarDisponibilidad(
            String profesional,
            LocalDate fecha) {

        String clave = profesional + "-" + fecha;

        Set<String> disponibles = agenda.get(clave);

        if (disponibles == null) {
            return Collections.emptySet();
        }

        return Collections.unmodifiableSet(
                new HashSet<>(disponibles)
        );
    }

    // Consultar turnos reservados
    public synchronized List<Turno> consultarTurnos() {
        return Collections.unmodifiableList(
                new ArrayList<>(turnos)
        );
    }
}

