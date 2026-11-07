public class CreadorJSON extends CreadorImportador {

    @Override
    public Importador crearImportador() {
        return new ImportadorJSON();
    }
}
