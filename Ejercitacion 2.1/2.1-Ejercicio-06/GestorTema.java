public class GestorTema {

    private static GestorTema instancia = null;

    private String temaActual;
    private String colorFondo;
    private String colorTexto;

    // Constructor privado
    private GestorTema() {
        temaActual = "Claro";
        colorFondo = "#FFFFFF";
        colorTexto = "#000000";

        System.out.println("Gestor de tema inicializado.");
    }

    // Obtiene la única instancia
    public static synchronized GestorTema getInstancia() {
        if (instancia == null) {
            instancia = new GestorTema();
        }
        return instancia;
    }

    // Cambia el tema y sus colores
    public synchronized void cambiarTema(String tema) {
        if (tema == null) {
            System.out.println("El tema no puede ser nulo.");
            return;
        }

        if (tema.equalsIgnoreCase("Claro")) {
            temaActual = "Claro";
            colorFondo = "#FFFFFF";
            colorTexto = "#000000";

        } else if (tema.equalsIgnoreCase("Oscuro")) {
            temaActual = "Oscuro";
            colorFondo = "#222222";
            colorTexto = "#FFFFFF";

        } else {
            System.out.println("Tema no válido. Use Claro u Oscuro.");
            return;
        }

        System.out.println("Tema cambiado a: " + temaActual);
    }

    // Consulta el tema actual
    public synchronized String obtenerTema() {
        return temaActual;
    }

    // Consulta el color de fondo
    public synchronized String obtenerColorFondo() {
        return colorFondo;
    }

    // Consulta el color del texto
    public synchronized String obtenerColorTexto() {
        return colorTexto;
    }

    public static void main(String[] args) {

        GestorTema vista1 = GestorTema.getInstancia();

        System.out.println("Tema actual: " + vista1.obtenerTema());
        System.out.println("Fondo: " + vista1.obtenerColorFondo());
        System.out.println("Texto: " + vista1.obtenerColorTexto());

        // Cambiar el tema desde una vista
        vista1.cambiarTema("Oscuro");

        // Otra vista obtiene la misma instancia
        GestorTema vista2 = GestorTema.getInstancia();

        System.out.println("Tema desde vista 2: "
                + vista2.obtenerTema());
        System.out.println("Fondo desde vista 2: "
                + vista2.obtenerColorFondo());

        System.out.println("¿Es la misma instancia? "
                + (vista1 == vista2));
    }
}
