public class Recepcion {

    private final ConfiguracionHospital configuracion;

    public Recepcion() {
        configuracion = ConfiguracionHospital.getInstancia();
    }

    public void mostrarConfiguracion() {
        System.out.println("MÓDULO DE RECEPCIÓN");
        System.out.println("Hospital: "
                + configuracion.getNombreHospital());
        System.out.println("Apertura: "
                + configuracion.getHorarioApertura());
        System.out.println("Cierre: "
                + configuracion.getHorarioCierre());
        System.out.println("Duración de turnos: "
                + configuracion.getDuracionTurnos() + " minutos");
    }

    public ConfiguracionHospital getConfiguracion() {
        return configuracion;
    }
}

