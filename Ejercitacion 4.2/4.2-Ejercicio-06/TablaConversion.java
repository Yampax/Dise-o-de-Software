public class TablaConversion implements ObservadorCotizacion {

    private double cantidad;

    public TablaConversion(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public void actualizar(Cotizacion cotizacion) {

        double conversion = cantidad * cotizacion.getPrecio();

        System.out.println("\n[TABLA DE CONVERSIÓN]");

        System.out.println(
            cantidad + " " + cotizacion.getMoneda()
        );

        System.out.println(
            "Equivalente en pesos: $" + conversion
        );
    }
}
