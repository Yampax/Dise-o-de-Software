public class Boton implements ComponenteUI {

    private int ancho;
    private int alto;

    public Boton(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }

    @Override
    public void renderizar() {
        System.out.println("Botón renderizado: "
                + ancho + "x" + alto);
    }

    public void hacerClic() {
        System.out.println("¡Botón presionado!");
    }
}
