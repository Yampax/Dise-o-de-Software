public class Main {

    public static void main(String[] args) {

        // Los tres sectores acceden al mismo registro
        Registro prestamos =
                Registro.getInstancia();

        Registro devoluciones =
                Registro.getInstancia();

        Registro atencion =
                Registro.getInstancia();

        // Registrar actividades
        prestamos.registrarActividad(
                "Préstamos", "Préstamo del libro El Principito");

        devoluciones.registrarActividad(
                "Devoluciones", "Devolución de El Principito");

        atencion.registrarActividad(
                "Atención a socios", "Actualización de datos de un socio");

        prestamos.registrarActividad(
                "Préstamos", "Préstamo del libro Don Quijote");

        // Comprobar que los tres usan la misma instancia
        System.out.println("¿Comparten el mismo registro? "
                + (prestamos == devoluciones
                && devoluciones == atencion));

        // Mostrar el historial completo
        System.out.println("\nHISTORIAL COMPLETO:");

        for (Evento evento : prestamos.obtenerHistorial()) {
            System.out.println(evento);
        }

        // Filtrar por sector
        System.out.println("\nACTIVIDADES DE PRÉSTAMOS:");

        for (Evento evento :
                devoluciones.filtrarPorSector("Préstamos")) {
            System.out.println(evento);
        }

        // Mostrar la cantidad total
        System.out.println("\nTotal de eventos: "
                + atencion.cantidadEventos());
    }
}
