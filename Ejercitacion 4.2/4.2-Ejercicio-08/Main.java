public class Main {

    public static void main(String[] args) {

        Inventario inventario = new Inventario("Teclado Gamer", 10);

        ModuloFacturacion facturacion = new ModuloFacturacion();
        ModuloEstadisticas estadisticas = new ModuloEstadisticas();

        // Suscripción de los módulos
        inventario.suscribir(facturacion);
        inventario.suscribir(estadisticas);

        // Modificaciones del stock
        inventario.modificarStock(-3);
        inventario.modificarStock(-4);
        inventario.modificarStock(-3);

        // Desuscripción de estadísticas
        inventario.desuscribir(estadisticas);

        // Nueva modificación
        inventario.modificarStock(10);
    }
}
