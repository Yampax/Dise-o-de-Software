public class Main {

    public static void main(String[] args) {

        // Crear el mercado
        MercadoDivisas mercado = new MercadoDivisas();

        // Crear observadores
        PanelGrafico grafico = new PanelGrafico();

        TablaConversion tabla = new TablaConversion(100);

        AlertaLimite alerta = new AlertaLimite(5);

        // Suscribir los observadores
        mercado.suscribir(grafico);
        mercado.suscribir(tabla);
        mercado.suscribir(alerta);

        // Registrar cotizaciones iniciales
        mercado.actualizarCotizacion("USD", 1000);
        mercado.actualizarCotizacion("EUR", 1200);

        // Actualizar el dólar
        mercado.actualizarCotizacion("USD", 1100);

        // Actualizar el euro
        mercado.actualizarCotizacion("EUR", 1180);

        // Otra variación del dólar
        mercado.actualizarCotizacion("USD", 1070);

        // Desuscribir la tabla de conversión
        mercado.desuscribir(tabla);

        System.out.println(
            "\nLa tabla de conversión dejó de recibir actualizaciones."
        );

        // Los demás observadores siguen recibiendo cambios
        mercado.actualizarCotizacion("USD", 950);
    }
}
