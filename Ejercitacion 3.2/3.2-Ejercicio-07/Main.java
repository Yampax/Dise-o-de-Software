public class Main {

    public static void main(String[] args) {

        InterfazGrafica escritorio =
                FabricaInterfaz.crear(TipoPantalla.ESCRITORIO);

        escritorio.renderizar();
        escritorio.interactuar();

        System.out.println();

        InterfazGrafica movil =
                FabricaInterfaz.crear(TipoPantalla.MOVIL);

        movil.renderizar();
        movil.interactuar();
    }
}
