public class Main {

    public static void main(String[] args) {

        // Crear gestor de canales
        GestorCanales gestor = new GestorCanales();

        // Crear usuarios
        Usuario juan = new Usuario("Juan");
        Usuario maria = new Usuario("María");
        Usuario pedro = new Usuario("Pedro");

        // Suscripciones de Juan
        gestor.suscribir("CANAL01", juan);
        gestor.suscribir("CANAL02", juan);

        // Suscripciones de María
        gestor.suscribir("CANAL01", maria);
        gestor.suscribir("CANAL03", maria);

        // Suscripciones de Pedro
        gestor.suscribir("CANAL02", pedro);

        // Publicar video en Canal 01
        Video video1 = new Video(
            "CANAL01",
            "Programación Fácil",
            "Aprendiendo Java desde cero",
            "Introducción a la programación en Java."
        );

        gestor.publicarVideo(video1);

        // Publicar video en Canal 02
        Video video2 = new Video(
            "CANAL02",
            "Gaming Argentina",
            "Nuevo gameplay",
            "Jugando un nuevo videojuego."
        );

        gestor.publicarVideo(video2);

        // Publicar video en Canal 03
        Video video3 = new Video(
            "CANAL03",
            "Cocina Fácil",
            "Receta de pizza casera",
            "Preparación de una pizza desde cero."
        );

        gestor.publicarVideo(video3);

        // Juan cancela su suscripción al Canal 01
        gestor.cancelarSuscripcion("CANAL01", juan);

        // Nueva publicación en Canal 01
        Video video4 = new Video(
            "CANAL01",
            "Programación Fácil",
            "Ejercicios prácticos de Java",
            "Nuevos ejercicios para practicar."
        );

        gestor.publicarVideo(video4);
    }
}
