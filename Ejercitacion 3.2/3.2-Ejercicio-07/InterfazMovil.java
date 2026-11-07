public class InterfazMovil implements InterfazGrafica {

    private Boton boton;
    private Etiqueta etiqueta;

    public InterfazMovil() {
        boton = new Boton(120, 40);
        etiqueta = new Etiqueta(250, 25, "Modo móvil");
    }

    @Override
    public void renderizar() {
        System.out.println("=== INTERFAZ MÓVIL ===");
        boton.renderizar();
        etiqueta.renderizar();
    }

    @Override
    public void interactuar() {
        boton.hacerClic();
    }
}
