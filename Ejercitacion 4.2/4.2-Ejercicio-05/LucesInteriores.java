public class LucesInteriores implements ObservadorLuz {

    @Override
    public void actualizar(double luminosidad) {

        if (luminosidad >= 700) {

            System.out.println(
                "Luces: Atenuando la iluminación interior."
            );

        } else if (luminosidad <= 300) {

            System.out.println(
                "Luces: Aumentando la iluminación interior."
            );

        } else {

            System.out.println(
                "Luces: Manteniendo la intensidad actual."
            );
        }
    }
}
