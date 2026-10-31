import java.time.LocalTime;
public class ConfiguracionHospital {
    private static ConfiguracionHospital instancia = null;

    private String nombreHospital;
    private LocalTime horarioApertura;
    private LocalTime horarioCierre;
    private int duracionTurnos;

    private ConfiguracionHospital() {
        nombreHospital = "Hospital Central";
        horarioApertura = LocalTime.of(8, 0);
        horarioCierre = LocalTime.of(20, 0);
        duracionTurnos = 30;
    }

    public static synchronized ConfiguracionHospital getInstancia() {
        if (instancia == null) {
            instancia = new ConfiguracionHospital();
        }
        return instancia;
    }

    public String getNombreHospital() {
        return nombreHospital;
    }

    public void setNombreHospital(String nombreHospital) {
        if (nombreHospital == null || nombreHospital.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío.");
        }
        this.nombreHospital = nombreHospital;
    }

    public LocalTime getHorarioApertura() {
        return horarioApertura;
    }

    public void setHorarioApertura(LocalTime horarioApertura) {
        if (horarioApertura == null
                || !horarioApertura.isBefore(horarioCierre)) {
            throw new IllegalArgumentException(
                    "La apertura debe ser anterior al cierre.");
        }
        this.horarioApertura = horarioApertura;
    }

    public LocalTime getHorarioCierre() {
        return horarioCierre;
    }

    public void setHorarioCierre(LocalTime horarioCierre) {
        if (horarioCierre == null
                || !horarioCierre.isAfter(horarioApertura)) {
            throw new IllegalArgumentException(
                    "El cierre debe ser posterior a la apertura.");
        }
        this.horarioCierre = horarioCierre;
    }

    public int getDuracionTurnos() {
        return duracionTurnos;
    }

    public void setDuracionTurnos(int duracionTurnos) {
        if (duracionTurnos <= 0) {
            throw new IllegalArgumentException(
                    "La duración debe ser mayor que cero.");
        }
        this.duracionTurnos = duracionTurnos;
    }
}
