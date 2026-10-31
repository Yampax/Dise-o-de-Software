import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GestorReserva gestor = GestorReserva.getInstancia();

        int cantidadSolicitudes = 30;

        Thread[] hilos = new Thread[cantidadSolicitudes];

        // Permite que todos los hilos comiencen juntos
        CountDownLatch inicio = new CountDownLatch(1);

        for (int i = 0; i < cantidadSolicitudes; i++) {

            final int numeroSocio = i + 1;

            hilos[i] = new Thread(() -> {

                try {
                    inicio.await();

                    String idSocio = "SOCIO-" + numeroSocio;

                    boolean resultado = gestor.reservar(idSocio);

                    synchronized (System.out) {
                        if (resultado) {
                            System.out.println(
                                    idSocio + ": Reserva aceptada.");
                        } else {
                            System.out.println(
                                    idSocio + ": Reserva rechazada.");
                        }
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });

            hilos[i].start();
        }

        // Liberar todos los hilos para que comiencen a solicitar
        inicio.countDown();

        // Esperar a que terminen todas las solicitudes
        for (Thread hilo : hilos) {
            hilo.join();
        }

        // Mostrar el estado final
        System.out.println("\nRESERVAS ACTIVAS:");

        List<Reserva> reservas = gestor.obtenerReservas();

        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }

        System.out.println("\nTotal de reservas: " + reservas.size());
        System.out.println("Lugares disponibles: "
                + gestor.lugaresDisponibles());

        // Comprobar que no se permite una reserva duplicada
        if (!reservas.isEmpty()) {
            String socio = reservas.get(0).getIdSocio();

            System.out.println("\nPRUEBA DE RESERVA DUPLICADA:");
            System.out.println("¿Se aceptó la reserva duplicada? "
                    + gestor.reservar(socio));

            // Cancelar una reserva existente
            System.out.println("\nPRUEBA DE CANCELACIÓN:");
            System.out.println("¿Se canceló la reserva? "
                    + gestor.cancelar(socio));
        }

        // Intentar cancelar una reserva inexistente
        int disponiblesAntes = gestor.lugaresDisponibles();

        System.out.println("\nCANCELACIÓN INEXISTENTE:");
        System.out.println("¿Se canceló la reserva? "
                + gestor.cancelar("SOCIO-999"));

        System.out.println("Lugares antes: " + disponiblesAntes);
        System.out.println("Lugares después: "
                + gestor.lugaresDisponibles());
    }
}
