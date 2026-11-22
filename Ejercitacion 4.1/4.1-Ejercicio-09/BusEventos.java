import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BusEventos {

    private final ConcurrentHashMap<String,
            CopyOnWriteArrayList<ObservadorEvento>> suscripciones =
            new ConcurrentHashMap<>();

    private final ExecutorService ejecutor =
            Executors.newFixedThreadPool(4);

    // Registrar un observador para un tipo de evento
    public void suscribir(String tipo,
                          ObservadorEvento observador) {

        suscripciones
                .computeIfAbsent(
                        tipo,
                        clave -> new CopyOnWriteArrayList<>()
                )
                .addIfAbsent(observador);
    }

    // Eliminar un observador de un tipo de evento
    public void desuscribir(String tipo,
                            ObservadorEvento observador) {

        CopyOnWriteArrayList<ObservadorEvento> lista =
                suscripciones.get(tipo);

        if (lista != null) {
            lista.remove(observador);
        }
    }

    // Publicar un evento de manera asíncrona
    public void publicar(Evento evento) {

        ejecutor.submit(() -> despachar(evento));
    }

    // Buscar y notificar únicamente a los observadores correspondientes
    private void despachar(Evento evento) {

        CopyOnWriteArrayList<ObservadorEvento> lista =
                suscripciones.get(evento.getTipo());

        if (lista == null || lista.isEmpty()) {
            System.out.println(
                    "No hay observadores para: " + evento.getTipo()
            );
            return;
        }

        for (ObservadorEvento observador : lista) {

            try {
                observador.actualizar(evento);

            } catch (Exception e) {

                System.out.println(
                        "Error en un observador de " +
                                evento.getTipo() + ": " + e.getMessage()
                );
            }
        }
    }

    // Finalizar los hilos del bus
    public void cerrar() {
        ejecutor.shutdown();
    }
}
