public class Main {

    public static void main(String[] args) {

        System.out.println("Iniciando aplicación...");

        // La instancia se crea cuando recepción la solicita
        Recepcion recepcion = new Recepcion();

        // Consultorios obtiene la misma instancia
        Consultorio consultorios = new Consultorio();

        // Comprobar que ambos módulos comparten el objeto
        System.out.println("\n¿Comparten la misma instancia? "
                + (recepcion.getConfiguracion()
                == consultorios.getConfiguracion()));

        // Mostrar configuración inicial
        recepcion.mostrarConfiguracion();

        // Modificar parámetros desde recepción
        recepcion.getConfiguracion()
                .setNombreHospital("Hospital Municipal");

        recepcion.getConfiguracion()
                .setHorarioApertura(java.time.LocalTime.of(7, 0));

        recepcion.getConfiguracion()
                .setHorarioCierre(java.time.LocalTime.of(22, 0));

        recepcion.getConfiguracion()
                .setDuracionTurnos(45);

        // Consultar los cambios desde consultorios
        System.out.println();
        consultorios.mostrarConfiguracion();

        // Obtener nuevamente la instancia
        ConfiguracionHospital otraReferencia =
                ConfiguracionHospital.getInstancia();

        System.out.println("\n¿Se conserva la misma instancia? "
                + (recepcion.getConfiguracion() == otraReferencia));
    }
}
