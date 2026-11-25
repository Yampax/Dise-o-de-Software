public class Main {

    public static void main(String[] args) {

        MarcadorPuntuacion marcador = new MarcadorPuntuacion();

        PantallaJuego pantalla = new PantallaJuego();
        SistemaRecords records = new SistemaRecords();

        // Suscribir los observadores
        marcador.suscribir(pantalla);
        marcador.suscribir(records);

        // Simular la obtención de puntos
        marcador.sumarPuntos(100);

        marcador.sumarPuntos(50);

        marcador.sumarPuntos(200);

        // El sistema de récords deja de recibir notificaciones
        marcador.desuscribir(records);

        System.out.println("\nSe desuscribió el sistema de récords.");

        // Solamente la pantalla recibe esta actualización
        marcador.sumarPuntos(150);
    }
}
