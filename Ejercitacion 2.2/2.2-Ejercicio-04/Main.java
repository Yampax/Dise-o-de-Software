public class Main {

    public static void main(String[] args) {
        // Ambos mostradores acceden al mismo administrador
        Administrador mostrador1 =
                Administrador.getInstancia();

        Administrador mostrador2 =
                Administrador.getInstancia();

        // Comprobar que comparten la misma instancia
        System.out.println("¿Comparten el mismo administrador? "
                + (mostrador1 == mostrador2));

        // Registrar un préstamo desde el mostrador 1
        System.out.println("\nMOSTRADOR 1:");
        mostrador1.registrarPrestamo("EJ-001", "Juan");

        // Intentar prestar el mismo ejemplar desde el mostrador 2
        System.out.println("\nMOSTRADOR 2:");
        mostrador2.registrarPrestamo("EJ-001", "María");

        // Registrar otro préstamo
        mostrador2.registrarPrestamo("EJ-002", "María");

        // Consultar préstamos activos de María
        System.out.println("\nPRÉSTAMOS ACTIVOS DE MARÍA:");

        for (Prestamos prestamo :
                mostrador1.consultarPrestamosSocio("María")) {
            System.out.println(prestamo);
        }

        // Registrar una devolución
        System.out.println("\nDEVOLUCIÓN:");
        mostrador2.registrarDevolucion("EJ-001");

        // Intentar prestar nuevamente el ejemplar
        System.out.println("\nNUEVO PRÉSTAMO:");
        mostrador1.registrarPrestamo("EJ-001", "María");

        // Intentar devolver un ejemplar sin préstamo activo
        System.out.println("\nDEVOLUCIÓN INEXISTENTE:");
        mostrador1.registrarDevolucion("EJ-999");
    }
}
