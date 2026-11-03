public class CreadorTextoPlano extends CreadorDocumento {

    @Override
    public Documento crearDocumento() {
        return new DocumentoTextoPlano();
    }
}
