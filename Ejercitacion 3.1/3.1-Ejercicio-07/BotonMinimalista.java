public class BotonMinimalista implements Boton {

    @Override
    public void renderizar() {
        System.out.println("[Botón minimalista móvil]");
    }

    @Override
    public void pulsar() {
        System.out.println("Botón minimalista presionado.");
    }
}
