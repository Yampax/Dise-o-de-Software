public class CreadorTarjeta extends CreadorPasarela {

    @Override
    protected PasarelaPago crearPasarela() {
        return new PagoTarjeta();
    }

    @Override
    protected double obtenerMontoMinimo() {
        return 100;
    }
}
