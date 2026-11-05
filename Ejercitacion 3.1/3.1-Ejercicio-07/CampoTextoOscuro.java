public class CampoTextoOscuro implements CampoTexto {

    @Override
    public void renderizar() {
        System.out.println("[Campo de texto oscuro de escritorio]");
    }

    @Override
    public void escribir(String texto) {
        System.out.println("Texto ingresado: " + texto);
    }
}
