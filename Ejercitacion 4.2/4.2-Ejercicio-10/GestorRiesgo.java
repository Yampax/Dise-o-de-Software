import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestorRiesgo {

    private ConcurrentHashMap<String, PerfilRiesgo> cuentas;

    private CopyOnWriteArrayList<ObservadorRiesgo> observadores;

    private RegistroAuditoria auditoria;

    public GestorRiesgo() {

        cuentas = new ConcurrentHashMap<>();
        observadores = new CopyOnWriteArrayList<>();
        auditoria = new RegistroAuditoria();
    }

    public void registrarCuenta(String cuenta, PerfilRiesgo riesgo) {

        cuentas.put(cuenta, riesgo);

        System.out.println("Cuenta registrada: "
                + cuenta + " - Riesgo: " + riesgo);
    }

    public void suscribir(ObservadorRiesgo observador) {

        observadores.addIfAbsent(observador);

        System.out.println("Observador registrado: "
                + observador.getNombre());
    }

    public void desuscribir(ObservadorRiesgo observador) {

        observadores.remove(observador);

        System.out.println("Observador eliminado: "
                + observador.getNombre());
    }

    public synchronized void modificarRiesgo(
            String cuenta,
            PerfilRiesgo riesgoNuevo,
            String motivo) {

        PerfilRiesgo riesgoAnterior = cuentas.get(cuenta);

        if (riesgoAnterior == null) {
            System.out.println("Error: cuenta inexistente.");
            return;
        }

        if (riesgoAnterior == riesgoNuevo) {
            System.out.println("El riesgo no cambió.");
            return;
        }

        // Se actualiza el perfil
        cuentas.put(cuenta, riesgoNuevo);

        // Se crea el evento inmutable
        CambioRiesgo cambio = new CambioRiesgo(
                cuenta,
                riesgoAnterior,
                riesgoNuevo,
                motivo
        );

        System.out.println("\n==================================");
        System.out.println("MODIFICACIÓN DE RIESGO");
        System.out.println("Cuenta: " + cuenta);
        System.out.println("Anterior: " + riesgoAnterior);
        System.out.println("Nuevo: " + riesgoNuevo);
        System.out.println("Motivo: " + motivo);
        System.out.println("==================================");

        notificarObservadores(cambio);
    }

    private void notificarObservadores(CambioRiesgo cambio) {

        for (ObservadorRiesgo observador : observadores) {

            try {

                System.out.println("\nNotificando a: "
                        + observador.getNombre());

                observador.procesarCambio(cambio);

                ResultadoNotificacion resultado =
                        new ResultadoNotificacion(
                                observador.getNombre(),
                                true,
                                "Procesamiento completado correctamente."
                        );

                auditoria.registrar(resultado);

            } catch (Exception e) {

                ResultadoNotificacion resultado =
                        new ResultadoNotificacion(
                                observador.getNombre(),
                                false,
                                "Error: " + e.getMessage()
                        );

                auditoria.registrar(resultado);

                System.out.println("[ERROR] Falló "
                        + observador.getNombre()
                        + ": " + e.getMessage());
            }
        }
    }

    public RegistroAuditoria getAuditoria() {
        return auditoria;
    }

    public PerfilRiesgo consultarRiesgo(String cuenta) {
        return cuentas.get(cuenta);
    }
}
