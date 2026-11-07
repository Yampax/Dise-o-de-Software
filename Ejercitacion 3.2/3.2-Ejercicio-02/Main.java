public class Main {

    public static void main(String[] args) {

        // Preferencia seleccionada por el usuario.
        String preferencia = "nube";

        CreadorAlmacenamiento creador;

        // Seleccionar el creador correspondiente.
        if (preferencia.equalsIgnoreCase("local")) {
            creador = new CreadorLocal();

        } else {
            creador = new CreadorNube();
        }

        // Gestionar archivos sin conocer la implementación concreta.
        creador.gestionarArchivos("fotografia.jpg");
    }
}
