public class Cotizacion {

    private String activo;
    private double precio;
    private double variacionPorcentual;

    public Cotizacion(String activo, double precio,
                      double variacionPorcentual) {
        this.activo = activo;
        this.precio = precio;
        this.variacionPorcentual = variacionPorcentual;
    }

    public String getActivo() {
        return activo;
    }

    public double getPrecio() {
        return precio;
    }

    public double getVariacionPorcentual() {
        return variacionPorcentual;
    }
}
