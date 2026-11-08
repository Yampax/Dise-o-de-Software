public class Main {

    public static void main(String[] args) {

        DatosSolicitud datos = new DatosSolicitud(
                "40123456",
                "Juan Pérez",
                "MAT-2026-001",
                "Junín, Mendoza"
        );

        ContextoJurisdiccion contextoMendoza =
                new ContextoJurisdiccion(
                        "Mendoza",
                        "Registro de la Propiedad",
                        "NOT-2026-001"
                );

        ContextoJurisdiccion contextoCordoba =
                new ContextoJurisdiccion(
                        "Córdoba",
                        "Registro General de la Provincia",
                        "NOT-2026-002"
                );

        CreadorTitulo creadorMendoza = new CreadorMendoza();
        CreadorTitulo creadorCordoba = new CreadorCordoba();

        try {
            System.out.println("=== TÍTULO DE MENDOZA ===");

            TituloPropiedad tituloMendoza =
                    creadorMendoza.emitir(datos, contextoMendoza);

            tituloMendoza.mostrarTitulo();
            System.out.println(tituloMendoza.obtenerFormato());

            System.out.println("\n=== TÍTULO DE CÓRDOBA ===");

            TituloPropiedad tituloCordoba =
                    creadorCordoba.emitir(datos, contextoCordoba);

            tituloCordoba.mostrarTitulo();
            System.out.println(tituloCordoba.obtenerFormato());

        } catch (IllegalArgumentException e) {
            System.out.println("No se pudo emitir el título: "
                    + e.getMessage());
        }
    }
}
