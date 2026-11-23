import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.ArrayList;

public class GestorRiesgo {

    private final CopyOnWriteArrayList<ObservadorRegulatorio> observadores =
            new CopyOnWriteArrayList<>();

    private PerfilRiesgo perfilActual;

    public GestorRiesgo(PerfilRiesgo perfilInicial) {
        this.perfilActual = perfilInicial;
    }

    // Registrar un observador
    public void suscribir(ObservadorRegulatorio observador) {
        if (observador != null) {
            observadores.addIfAbsent(observador);
        }
    }

    // Eliminar un observador
    public void desuscribir(ObservadorRegulatorio observador) {
        observadores.remove(observador);
    }

    // Cambiar el perfil y notificar secuencialmente
    public synchronized RegistroAuditoria cambiarPerfil(
            int idCliente,
            PerfilRiesgo nuevoPerfil) {

        if (nuevoPerfil == null) {
            throw new IllegalArgumentException(
                    "El nuevo perfil no puede ser nulo");
        }

        if (perfilActual == nuevoPerfil) {
            throw new IllegalArgumentException(
                    "El cliente ya tiene ese perfil de riesgo");
        }

        PerfilRiesgo perfilAnterior = perfilActual;

        CambioRiesgo cambio = new CambioRiesgo(
                idCliente,
                perfilAnterior,
                nuevoPerfil
        );

        // Actualizar el estado del cliente
        perfilActual = nuevoPerfil;

        // Lista temporal para recopilar los resultados
        List<ResultadoNotificacion> resultados = new ArrayList<>();

        // Notificar a cada observador de forma secuencial
        for (ObservadorRegulatorio observador : observadores) {

            String nombre = observador.getClass().getSimpleName();

            try {
                nombre = observador.getNombre();

                observador.procesar(cambio);

                resultados.add(
                        new ResultadoNotificacion(
                                nombre,
                                true,
                                "Procesamiento completado correctamente"
                        )
                );

            } catch (Exception e) {

                resultados.add(
                        new ResultadoNotificacion(
                                nombre,
                                false,
                                "Error: " + e.getMessage()
                        )
                );
            }
        }

        // Crear el registro inmutable de auditoría
        return new RegistroAuditoria(idCliente, resultados);
    }

    public synchronized PerfilRiesgo getPerfilActual() {
        return perfilActual;
    }
}
