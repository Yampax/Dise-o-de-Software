import java.util.concurrent.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class BusEventos {

    private ConcurrentHashMap<String, CopyOnWriteArrayList<ObservadorEvento>>
            observadores;

    private ExecutorService executor;

    public BusEventos() {

        observadores = new ConcurrentHashMap<>();

        executor = Executors.newFixedThreadPool(4);
    }

    public void suscribir(String tipo, ObservadorEvento observador) {

        observadores
                .computeIfAbsent(tipo, t -> new CopyOnWriteArrayList<>())
                .addIfAbsent(observador);

        System.out.println("Observador suscripto al evento: " + tipo);
    }

    public void desuscribir(String tipo, ObservadorEvento observador) {

        CopyOnWriteArrayList<ObservadorEvento> lista =
                observadores.get(tipo);

        if (lista != null) {
            lista.remove(observador);

            System.out.println("Observador desuscripto del evento: " + tipo);
        }
    }

    public void publicar(Evento evento) {

        CopyOnWriteArrayList<ObservadorEvento> lista =
                observadores.get(evento.getTipo());

        if (lista == null || lista.isEmpty()) {
            System.out.println("No hay observadores para: "
                    + evento.getTipo());
            return;
        }

        for (ObservadorEvento observador : lista) {

            executor.submit(() -> {

                try {
                    observador.procesarEvento(evento);

                } catch (Exception e) {

                    System.out.println("[ERROR] Un observador falló: "
                            + e.getMessage());
                }
            });
        }
    }

    public void cerrar() {
        executor.shutdown();
    }
}
