public class AlertaLimite implements ObservadorCotizacion {

    private double limite;

    public AlertaLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void actualizar(Cotizacion cotizacion) {

        double variacion = cotizacion.getVariacionPorcentual();

        if (Math.abs(variacion) >= limite) {

            System.out.println("\n[ALERTA FINANCIERA]");

            System.out.println(
                "Variación significativa en " + cotizacion.getMoneda()
            );

            System.out.printf(
                "Variación detectada: %.2f%%%n",
                variacion
            );
        }
    }
}
