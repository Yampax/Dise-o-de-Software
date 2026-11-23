import java.util.List;

public class RegistroAuditoria {

    private final int idCliente;
    private final List<ResultadoNotificacion> resultados;

    public RegistroAuditoria(int idCliente,
                             List<ResultadoNotificacion> resultados) {

        this.idCliente = idCliente;

        this.resultados = List.copyOf(resultados);
    }

    public int getIdCliente() {
        return idCliente;
    }

    public List<ResultadoNotificacion> getResultados() {
        return resultados;
    }

    public void mostrarAuditoria() {

        System.out.println("\n===== REGISTRO DE AUDITORÍA =====");

        System.out.println("Cliente: " + idCliente);

        for (ResultadoNotificacion resultado : resultados) {
            System.out.println(resultado);
        }

        System.out.println("================================");
    }
}
