public class Cotizacion {

    private final String moneda;
    private final double precio;
    private final double variacionPorcentual;

    public Cotizacion(String moneda,
                     double precio,
                     double variacionPorcentual) {

        this.moneda = moneda;
        this.precio = precio;
        this.variacionPorcentual = variacionPorcentual;
    }

    public String getMoneda() {
        return moneda;
    }

    public double getPrecio() {
        return precio;
    }

    public double getVariacionPorcentual() {
        return variacionPorcentual;
    }
}
