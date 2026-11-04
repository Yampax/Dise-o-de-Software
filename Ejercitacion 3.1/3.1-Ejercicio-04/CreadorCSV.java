public class CreadorCSV extends CreadorExportador {

    @Override
    public ExportadorReporte crearExportador() {
        return new ExportadorCSV();
    }
}
