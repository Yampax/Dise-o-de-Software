public class CreadorXML extends CreadorImportador {

    @Override
    public Importador crearImportador() {
        return new ImportadorXML();
    }
}
