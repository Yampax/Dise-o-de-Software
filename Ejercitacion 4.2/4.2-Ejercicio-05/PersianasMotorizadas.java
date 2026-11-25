public class PersianasMotorizadas implements ObservadorLuz {

    @Override
    public void actualizar(double luminosidad) {

        if (luminosidad >= 700) {

            System.out.println(
                "Persianas: Cerrando para reducir la entrada de luz solar."
            );

        } else if (luminosidad <= 300) {

            System.out.println(
                "Persianas: Abriendo para permitir la entrada de luz."
            );

        } else {

            System.out.println(
                "Persianas: Manteniendo la posición actual."
            );
        }
    }
}
