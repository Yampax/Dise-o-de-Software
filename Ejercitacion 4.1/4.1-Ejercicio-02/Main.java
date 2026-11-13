public class Main {

    public static void main(String[] args) {

        Reproductor reproductor = new Reproductor();

        // Creamos las tres vistas
        VistaReproductor barraInferior =
                new VistaReproductor("Barra inferior");

        VistaReproductor ventanaFlotante =
                new VistaReproductor("Ventana flotante");

        VistaReproductor widgetPrincipal =
                new VistaReproductor("Widget principal");

        // Suscribimos las vistas al reproductor
        reproductor.suscribir(barraInferior);
        reproductor.suscribir(ventanaFlotante);
        reproductor.suscribir(widgetPrincipal);

        // Cambiamos la canción
        reproductor.cambiarCancion("Bohemian Rhapsody");

        // Iniciamos la reproducción
        reproductor.cambiarEstado(EstadoReproduccion.REPRODUCIENDO);

        // Pausamos el audio
        reproductor.cambiarEstado(EstadoReproduccion.PAUSADO);

        // Eliminamos una vista de las suscripciones
        reproductor.desuscribir(ventanaFlotante);

        // Detenemos la reproducción
        reproductor.cambiarEstado(EstadoReproduccion.DETENIDO);
    }
}
