import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RegistroAuditoria {

    private final List<ResultadoNotificacion> registros;

    public RegistroAuditoria() {
        registros = new ArrayList<>();
    }

    public synchronized void registrar(ResultadoNotificacion resultado) {
        registros.add(resultado);
    }

    public synchronized List<ResultadoNotificacion> obtenerRegistros() {

        return Collections.unmodifiableList(
                new ArrayList<>(registros)
        );
    }

    public synchronized void mostrarRegistros() {

        System.out.println("\n===== REGISTRO DE AUDITORÍA =====");

        for (ResultadoNotificacion resultado : registros) {
            System.out.println(resultado);
        }

        System.out.println("=================================");
    }
}
