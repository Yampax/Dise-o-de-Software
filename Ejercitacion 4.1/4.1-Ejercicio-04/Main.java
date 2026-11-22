public class Main {

    public static void main(String[] args) {

        // Creamos un producto
        Producto producto = new Producto("Auriculares Bluetooth", 50, 10);

        // Creamos los departamentos
        DepartamentoCompras compras = new DepartamentoCompras();
        DepartamentoMarketing marketing = new DepartamentoMarketing();

        // Suscribimos los departamentos
        producto.suscribir(compras);
        producto.suscribir(marketing);

        // Simulamos ventas
        producto.vender(15);
        producto.vender(20);
        producto.vender(6);

        // Eliminamos un observador
        producto.desuscribir(marketing);

        // Nueva venta
        producto.vender(5);
    }
}
