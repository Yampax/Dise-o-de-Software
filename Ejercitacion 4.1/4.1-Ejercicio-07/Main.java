public class Main {

    public static void main(String[] args) {

        // Creamos el gestor central
        GestorPublicaciones gestor = new GestorPublicaciones();

        // Creamos los usuarios
        Usuario usuario1 = new Usuario("Juan");
        Usuario usuario2 = new Usuario("Maria");
        Usuario usuario3 = new Usuario("Pedro");

        // Registramos las suscripciones
        gestor.suscribir("Tecnologia", usuario1);
        gestor.suscribir("Deportes", usuario1);

        gestor.suscribir("Economia", usuario2);
        gestor.suscribir("Tecnologia", usuario2);

        gestor.suscribir("Deportes", usuario3);

        // Publicamos noticias
        Noticia noticia1 = new Noticia(
                "Nuevos avances en inteligencia artificial",
                "Se presentaron nuevas herramientas de IA.",
                "Tecnologia"
        );

        Noticia noticia2 = new Noticia(
                "Argentina ganó el partido",
                "La selección consiguió una nueva victoria.",
                "Deportes"
        );

        Noticia noticia3 = new Noticia(
                "Cambios en el mercado financiero",
                "Se registraron variaciones en los mercados.",
                "Economia"
        );

        gestor.publicar(noticia1);
        gestor.publicar(noticia2);
        gestor.publicar(noticia3);

        // Cancelamos una suscripción
        gestor.cancelarSuscripcion("Tecnologia", usuario1);

        // Publicamos otra noticia de Tecnología
        Noticia noticia4 = new Noticia(
                "Nueva generación de procesadores",
                "Se anunciaron nuevos procesadores.",
                "Tecnologia"
        );

        gestor.publicar(noticia4);
    }
}
