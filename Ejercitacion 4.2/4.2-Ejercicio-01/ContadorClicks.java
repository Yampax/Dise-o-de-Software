public class ContadorClicks implements ObservadorClick {

    private int contador = 0;

    @Override
    public void alHacerClick() {

        contador++;

        System.out.println(
                "Cantidad de clics registrados: " + contador
        );
    }
}
