public class Main {

    public static void main(String[] args) {

        // Creamos el gestor de empleados
        GestorEmpleados gestor = new GestorEmpleados();

        // Creamos los auditores
        AuditorConsola consola = new AuditorConsola();
        AuditorArchivo archivo = new AuditorArchivo();

        // Suscribimos los auditores
        gestor.suscribir(consola);
        gestor.suscribir(archivo);

        // Registramos un empleado
        Empleado empleado = new Empleado(
                1, "Juan Pérez", "Administrativo");

        gestor.agregarEmpleado(empleado);

        // Modificamos sus datos
        gestor.modificarEmpleado(
                1, "Juan Pérez", "Gerente");

        // Eliminamos al empleado
        gestor.eliminarEmpleado(1);

        // Desuscribimos el auditor de consola
        gestor.desuscribir(consola);

        // Registramos otro empleado
        Empleado empleado2 = new Empleado(
                2, "María López", "Contadora");

        gestor.agregarEmpleado(empleado2);
    }
}
