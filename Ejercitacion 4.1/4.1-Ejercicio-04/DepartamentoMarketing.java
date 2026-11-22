public class DepartamentoMarketing implements Observador {

    @Override
    public void actualizar(String producto, int stock) {
        System.out.println("Departamento de Marketing:");
        System.out.println("Evaluar campaña de liquidación para: " + producto);
        System.out.println("Stock disponible: " + stock);
        System.out.println("-------------------------");
    }
}
