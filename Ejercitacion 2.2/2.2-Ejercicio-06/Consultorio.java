public class Consultorio {

    private final ConfiguracionHospital configuracion;

    public Consultorio() {
        configuracion = ConfiguracionHospital.getInstancia();
    }

    public void mostrarConfiguracion() {
        System.out.println("MÓDULO DE CONSULTORIOS");
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
