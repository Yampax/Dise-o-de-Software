public class Main {

    public static void main(String[] args) {

        // Creamos el mercado con un precio inicial
        MercadoBursatil mercado =
                new MercadoBursatil("YPF", 1000);

        // Creamos los paneles
        PanelGrafico grafico = new PanelGrafico();
        PanelResumen resumen = new PanelResumen();
        AlertaVolatilidad alerta = new AlertaVolatilidad();

        // Suscribimos los paneles
        mercado.suscribir(grafico);
        mercado.suscribir(resumen);
        mercado.suscribir(alerta);

        // Actualizamos las cotizaciones
        mercado.actualizarPrecio(1050);
        mercado.actualizarPrecio(1100);
        mercado.actualizarPrecio(1000);

        // Eliminamos un observador
        mercado.desuscribir(grafico);

        // Nueva actualización
        mercado.actualizarPrecio(950);
    }
}
