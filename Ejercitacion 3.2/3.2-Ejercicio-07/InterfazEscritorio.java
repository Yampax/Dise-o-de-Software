public class InterfazEscritorio implements InterfazGrafica {

    private Boton boton;
    private Etiqueta etiqueta;

    public InterfazEscritorio() {
        boton = new Boton(160, 45);
        etiqueta = new Etiqueta(300, 30, "Modo escritorio");
    }

    @Override
    public void renderizar() {
        System.out.println("=== INTERFAZ ESCRITORIO ===");
        boton.renderizar();
        etiqueta.renderizar();
    }

    @Override
    public void interactuar() {
        boton.hacerClic();
    }
}
