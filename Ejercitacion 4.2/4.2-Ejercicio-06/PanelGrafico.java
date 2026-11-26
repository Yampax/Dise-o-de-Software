public class PanelGrafico implements ObservadorCotizacion {

    @Override
    public void actualizar(Cotizacion cotizacion) {

        System.out.println("\n[PANEL GRÁFICO]");

        System.out.println(
            "Actualizando gráfico de " + cotizacion.getMoneda()
        );

        System.out.println(
            "Nuevo valor: $" + cotizacion.getPrecio()
        );

        if (cotizacion.getVariacionPorcentual() > 0) {

            System.out.println("Tendencia: SUBIDA");

        } else if (cotizacion.getVariacionPorcentual() < 0) {

            System.out.println("Tendencia: BAJADA");

        } else {

            System.out.println("Tendencia: SIN VARIACIÓN");
        }
    }
}
