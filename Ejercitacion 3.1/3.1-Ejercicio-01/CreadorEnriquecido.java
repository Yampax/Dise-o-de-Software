public class CreadorEnriquecido extends CreadorDocumento {

    @Override
    public Documento crearDocumento() {
        return new DocumentoEnriquecido();
    }
}
