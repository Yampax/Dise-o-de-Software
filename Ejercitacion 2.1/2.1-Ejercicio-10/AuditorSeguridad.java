import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AuditorSeguridad {

    private static AuditorSeguridad instancia = null;

    private final List<String> registros;

    private AuditorSeguridad() {
        registros = new ArrayList<>();
    }

    public static synchronized AuditorSeguridad getInstancia() {
        if (instancia == null) {
            instancia = new AuditorSeguridad();
        }
        return instancia;
    }

    public synchronized void registrarEvento(String idSesion, String accion) {
        String fecha = LocalDateTime.now().toString();

        String registro = fecha
                + " | Sesión: " + idSesion
                + " | Acción: " + accion;

        registros.add(registro);
    }

    public synchronized int cantidadRegistros() {
        return registros.size();
    }

    public synchronized List<String> obtenerTraza() {
        return Collections.unmodifiableList(
                new ArrayList<>(registros)
        );
    }

    public static void main(String[] args) {
        AuditorSeguridad auditor1 = AuditorSeguridad.getInstancia();
        AuditorSeguridad auditor2 = AuditorSeguridad.getInstancia();

        auditor1.registrarEvento("SES-001", "Inicio de sesión");
        auditor1.registrarEvento("SES-001", "Transferencia realizada");
        auditor2.registrarEvento("SES-002", "Modificación de privilegios");

        System.out.println("Cantidad de registros: "
                + auditor1.cantidadRegistros());

        for (String registro : auditor1.obtenerTraza()) {
            System.out.println(registro);
        }

        System.out.println("¿Es la misma instancia? "
                + (auditor1 == auditor2));
    }
}
