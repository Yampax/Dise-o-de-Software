public abstract class CreadorDocumento {

    public abstract Documento crearDocumento();

    public void abrirDocumento() {

        Documento documento = crearDocumento();

        documento.abrir();
    }
}
