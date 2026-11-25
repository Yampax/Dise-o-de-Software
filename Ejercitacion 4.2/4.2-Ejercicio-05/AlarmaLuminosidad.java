public class AlarmaLuminosidad implements ObservadorLuz {

    @Override
    public void actualizar(double luminosidad) {

        if (luminosidad >= 900) {

            System.out.println(
                "Alarma: Se detectó una intensidad solar muy elevada."
            );
        }
    }
}
