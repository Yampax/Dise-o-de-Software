public class CreadorCSV extends CreadorImportador {

    @Override
    public Importador crearImportador() {
        return new ImportadorCSV();
    }
}
