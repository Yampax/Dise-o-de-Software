public class CreadorTicket extends CreadorComprobante {

    @Override
    public GeneradorComprobante crearGenerador() {
        return new GeneradorTicket();
    }
}
