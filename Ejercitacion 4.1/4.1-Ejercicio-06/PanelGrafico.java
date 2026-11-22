public class PanelGrafico implements Observador {

    @Override
    public void actualizar(Cotizacion cotizacion) {
        System.out.println("\nPANEL GRÁFICO");
        System.out.println("Activo: " + cotizacion.getActivo());
        System.out.println("Nuevo precio: $" + cotizacion.getPrecio());
        System.out.println("Actualizar gráfico de líneas.");
    }
}
