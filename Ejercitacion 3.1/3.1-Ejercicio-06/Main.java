public class Main {

    public static void main(String[] args) {

        FabricaPagos fabrica = new FabricaPagos();

        OrdenCompra orden1 =
            new OrdenCompra("tarjeta", 1000);

        OrdenCompra orden2 =
            new OrdenCompra("transferencia", 2000);

        OrdenCompra orden3 =
            new OrdenCompra("monedero", 500);

        try {

            Comprobante comprobante1 =
                fabrica.procesarPago(orden1);

            comprobante1.mostrarComprobante();

            Comprobante comprobante2 =
                fabrica.procesarPago(orden2);

            comprobante2.mostrarComprobante();

            Comprobante comprobante3 =
                fabrica.procesarPago(orden3);

            comprobante3.mostrarComprobante();

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
