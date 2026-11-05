public class CreadorTransferencia extends CreadorPasarela {

    @Override
    protected PasarelaPago crearPasarela() {
        return new PagoTransferencia();
    }

    @Override
    protected double obtenerMontoMinimo() {
        return 500;
    }
}
