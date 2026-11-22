public class AlertaVolatilidad implements Observador {

    private static final double UMBRAL_VOLATILIDAD = 5.0;

    @Override
    public void actualizar(Cotizacion cotizacion) {

        double variacion = cotizacion.getVariacionPorcentual();

        if (Math.abs(variacion) >= UMBRAL_VOLATILIDAD) {
            System.out.println("\n¡ALERTA DE VOLATILIDAD!");
            System.out.println("Activo: " + cotizacion.getActivo());

            System.out.printf(
                    "Variación importante: %.2f%%%n",
                    variacion
            );
        }
    }
}
