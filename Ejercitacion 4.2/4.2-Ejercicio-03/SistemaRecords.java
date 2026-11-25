public class SistemaRecords implements ObservadorPuntuacion {

    @Override
    public void actualizar(int puntuacion) {

        System.out.println(
            "Sistema de récords: Puntuación registrada = " + puntuacion
        );
    }
}
