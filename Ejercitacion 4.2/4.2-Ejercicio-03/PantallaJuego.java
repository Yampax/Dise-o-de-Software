public class PantallaJuego implements ObservadorPuntuacion {

    @Override
    public void actualizar(int puntuacion) {

        System.out.println(
            "Pantalla del juego: Puntuación actual = " + puntuacion
        );
    }
}
