public class CampoTextoMinimalista implements CampoTexto {

    @Override
    public void renderizar() {
        System.out.println("[Campo de texto minimalista móvil]");
    }

    @Override
    public void escribir(String texto) {
        System.out.println("Texto ingresado: " + texto);
    }
}
