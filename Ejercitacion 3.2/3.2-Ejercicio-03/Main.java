public class Main {

    public static void main(String[] args) {

        // Crear alertas por consola.
        CreadorAlerta creadorConsola = new CreadorConsola();

        creadorConsola.enviarMensaje(
                "El servidor principal está funcionando correctamente."
        );

        System.out.println();

        // Crear alertas por archivo.
        CreadorAlerta creadorArchivo = new CreadorArchivo();

        creadorArchivo.enviarMensaje(
                "Se detectó un aumento en el uso de memoria del servidor."
        );
    }
}
