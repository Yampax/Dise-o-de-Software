public class Etiqueta implements ComponenteUI {

    private int ancho;
    private int alto;
    private String texto;

    public Etiqueta(int ancho, int alto, String texto) {
        this.ancho = ancho;
        this.alto = alto;
        this.texto = texto;
    }

    @Override
    public void renderizar() {
        System.out.println("Etiqueta: " + texto);
        System.out.println("Dimensiones: "
                + ancho + "x" + alto);
    }
}
