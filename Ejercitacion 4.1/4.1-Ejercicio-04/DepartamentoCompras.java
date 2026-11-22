public class DepartamentoCompras implements Observador {

    @Override
    public void actualizar(String producto, int stock) {
        System.out.println("Departamento de Compras:");
        System.out.println("Reabastecer producto: " + producto);
        System.out.println("Unidades disponibles: " + stock);
        System.out.println("-------------------------");
    }
}
