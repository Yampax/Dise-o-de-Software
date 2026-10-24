public class Controlador {
    private static class instanciaC {
        private static final Controlador Instancia = new Controlador();
    }
    private boolean disponible;
    private String estado;

    private Controlador(){
        disponible = true;
        estado = "en espera";
        System.out.println("Controlador de hardware activado");
    }

    public static Controlador getInstance(){
        return instanciaC.Instancia;
    }

    public synchronized boolean estaDisponible() {
        return disponible;
    }

    public synchronized String obtenerEstado() {
        return estado;
    }

    public synchronized void enviarComando(String comando) {
        if (comando == null || comando.isBlank()) {
            System.out.println("Error: el comando no es válido.");
            return;
        }

        if (!disponible) {
            System.out.println(
                    "Dispositivo ocupado. No se puede ejecutar el comando."
            );
            return;
        }

        disponible = false;
        estado = "Ejecutando comando: " + comando;

        System.out.println("Enviando comando al dispositivo: " + comando);

        // Simulación de la ejecución del comando.
        estado = "En espera";
        disponible = true;

        System.out.println("Comando finalizado correctamente.");
    }

    public static void main(String[] args) {
        Controlador controlador1 =
                Controlador.getInstance();

        System.out.println(
                "¿Está disponible? " + controlador1.estaDisponible()
        );

        controlador1.enviarComando("AVANZAR");

        System.out.println(
                "Estado actual: " + controlador1.obtenerEstado()
        );

        Controlador controlador2 =
                Controlador.getInstance();

        System.out.println(
                "¿Es la misma instancia? "
                        + (controlador1 == controlador2)
        );
    }
}
