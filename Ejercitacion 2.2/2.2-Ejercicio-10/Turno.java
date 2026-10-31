import java.time.LocalDate;
public class Turno {

    private final String paciente;
    private final String profesional;
    private final LocalDate fecha;
    private final String horario;

    public Turno(String paciente, String profesional,
                 LocalDate fecha, String horario) {
        this.paciente = paciente;
        this.profesional = profesional;
        this.fecha = fecha;
        this.horario = horario;
    }

    public String getPaciente() {
        return paciente;
    }

    public String getProfesional() {
        return profesional;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "Paciente: " + paciente +
                " | Profesional: " + profesional +
                " | Fecha: " + fecha +
                " | Horario: " + horario;
    }
}

