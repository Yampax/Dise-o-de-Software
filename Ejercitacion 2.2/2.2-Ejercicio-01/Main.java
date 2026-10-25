public class Main {

    public static void main(String[] args) {

        Prestamo prestamos = new Prestamo();
        Consultas consultas = new Consultas();

        // Comprobar que ambos módulos utilizan el mismo objeto
        System.out.println("¿Comparten la misma configuración? "
                + (prestamos.getConfiguracion()
                == consultas.getConfiguracion()));

        System.out.println();

        prestamos.mostrarConfiguracion();
        System.out.println();

        // Modificar la configuración desde el módulo de préstamos
        prestamos.getConfiguracion()
                .setNombreBiblioteca("Biblioteca Municipal");

        prestamos.getConfiguracion().setMaxLibrosPorSocio(8);
        prestamos.getConfiguracion().setPlazoDevolucion(20);

        // Consultar los cambios desde el otro módulo
        System.out.println();
        consultas.mostrarConfiguracion();
    }
}
