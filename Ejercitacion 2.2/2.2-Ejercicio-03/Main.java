public class Main {

    public static void main(String[] args) {
        // Acceso desde la pantalla del personal
        CatalogoL pantallaPersonal =
                CatalogoL.getInstancia();

        // Acceso desde la pantalla de consulta
        CatalogoL pantallaConsulta =
                CatalogoL.getInstancia();

        // Incorporar libros desde el personal
        pantallaPersonal.agregarLibro(
                new Libro("L001", "El Principito",
                        "Antoine de Saint-Exupéry", 5));

        pantallaPersonal.agregarLibro(
                new Libro("L002", "Don Quijote",
                        "Miguel de Cervantes", 3));

        // Comprobar que ambas pantallas usan el mismo objeto
        System.out.println("¿Comparten el mismo catálogo? "
                + (pantallaPersonal == pantallaConsulta));

        // Consultar los libros desde la otra pantalla
        System.out.println("\nCATÁLOGO DESDE LA PANTALLA DE CONSULTA:");

        for (Libro libro : pantallaConsulta.obtenerCatalogo()) {
            System.out.println(libro);
        }

        // Buscar por título
        System.out.println("\nBÚSQUEDA POR TÍTULO:");

        for (Libro libro :
                pantallaConsulta.buscarPorTitulo("Principito")) {
            System.out.println(libro);
        }

        // Buscar por autor
        System.out.println("\nBÚSQUEDA POR AUTOR:");

        for (Libro libro :
                pantallaConsulta.buscarPorAutor("Cervantes")) {
            System.out.println(libro);
        }

        // Actualizar ejemplares desde el personal
        pantallaPersonal.actualizarCantidad("L001", 8);

        // Comprobar que la consulta refleja la modificación
        System.out.println("\nCATÁLOGO ACTUALIZADO:");

        for (Libro libro : pantallaConsulta.obtenerCatalogo()) {
            System.out.println(libro);
        }
    }
}
