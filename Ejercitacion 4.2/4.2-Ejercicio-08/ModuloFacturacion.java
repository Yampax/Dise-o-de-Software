public class ModuloFacturacion implements ObservadorStock {

    @Override
    public void actualizarStock(String producto, int stockActual) {

        System.out.println("[Facturación] Stock actualizado de "
                + producto + ": " + stockActual);

        if (stockActual > 0) {
            System.out.println("[Facturación] El producto puede venderse.");
        } else {
            System.out.println("[Facturación] Producto sin stock.");
        }
    }
}
