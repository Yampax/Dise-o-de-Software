public class CreadorMonedero extends CreadorPasarela {

    @Override
    protected PasarelaPago crearPasarela() {
        return new PagoMonedero();
    }

    @Override
    protected double obtenerMontoMinimo() {
        return 50;
    }
}
