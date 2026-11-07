public class CreadorPDF extends CreadorComprobante {

    @Override
    public GeneradorComprobante crearGenerador() {
        return new GeneradorPDF();
    }
}
