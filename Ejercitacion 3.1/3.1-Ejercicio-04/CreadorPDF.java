public class CreadorPDF extends CreadorExportador {

    @Override
    public ExportadorReporte crearExportador() {
        return new ExportadorPDF();
    }
}
