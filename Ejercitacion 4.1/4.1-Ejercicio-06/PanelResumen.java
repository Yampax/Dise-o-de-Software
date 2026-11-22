public class PanelResumen implements Observador {

    @Override
    public void actualizar(Cotizacion cotizacion) {
        System.out.println("\nPANEL DE RESUMEN");
        System.out.println("Activo: " + cotizacion.getActivo());
        System.out.println("Precio actual: $" + cotizacion.getPrecio());

        System.out.printf(
                "Variación: %.2f%%%n",
                cotizacion.getVariacionPorcentual()
        );
    }
}
