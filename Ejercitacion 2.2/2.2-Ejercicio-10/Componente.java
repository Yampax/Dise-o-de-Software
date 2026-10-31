import java.time.LocalDate;
import java.util.Set;
public class Componente {

    private String nombre;
    private AdministradorTurnos administrador;

    public Componente(String nombre) {
        this.nombre = nombre;
        this.administrador = AdministradorTurnos.getInstancia();
    }

    public boolean solicitarTurno(
            String paciente,
            String profesional,
            LocalDate fecha,
            String horario) {

        boolean resultado = administrador.reservarTurno(
                paciente, profesional, fecha, horario
        );

        if (resultado) {
            System.out.println(nombre + ": turno reservado para "
                    + paciente);
        } else {
            System.out.println(nombre + ": turno no disponible para "
                    + paciente);
        }

        return resultado;
    }

    public void consultarAgenda(
            String profesional,
            LocalDate fecha) {

        Set<String> horarios =
                administrador.consultarDisponibilidad(profesional, fecha);

        System.out.println(nombre + " - Horarios disponibles: "
                + horarios);
    }
}

