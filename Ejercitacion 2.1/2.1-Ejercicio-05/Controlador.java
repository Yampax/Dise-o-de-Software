public class Controlador {

    private static Controlador instancia = null;

    private boolean disponible;
    private String estado;

    private Controlador() {
        disponible = true;
        estado = "En espera";
        System.out.println("Controlador inicializado.");
    }

    public static synchronized Controlador getInstancia() {
        if (instancia == null) {
            instancia = new Controlador();
        }
        return instancia;
    }

    public synchronized boolean estaDisponible() {
        return disponible;
    }

    public synchronized String obtenerEstado() {
        return estado;
    }

    public synchronized void enviarComando(String comando) {
        if (comando == null || comando.isBlank()) {
            System.out.println("El comando no es válido.");
            return;
        }

        if (!disponible) {
            System.out.println("El dispositivo está ocupado.");
            return;
        }

        disponible = false;
        estado = "Ejecutando comando: " + comando;

        System.out.println("Enviando comando: " + comando);

        estado = "En espera";
        disponible = true;

        System.out.println("Comando finalizado.");
    }

    public static void main(String[] args) {
        Controlador controlador1 =
                Controlador.getInstancia();

        controlador1.enviarComando("AVANZAR");

        Controlador controlador2 =
                Controlador.getInstancia();

        System.out.println(
                "¿Es la misma instancia? "
                        + (controlador1 == controlador2)
        );
    }
}
