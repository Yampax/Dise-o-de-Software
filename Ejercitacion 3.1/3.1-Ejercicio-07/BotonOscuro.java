public class BotonOscuro implements Boton {

    @Override
    public void renderizar() {
        System.out.println("[Botón oscuro de escritorio]");
    }

    @Override
    public void pulsar() {
        System.out.println("Botón oscuro presionado.");
    }
}
