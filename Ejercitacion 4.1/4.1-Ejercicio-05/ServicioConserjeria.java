public class ServicioConserjeria implements Observador {

    @Override
    public void actualizar(String ubicacion, String mensaje) {
        System.out.println("\nSERVICIO DE CONSERJERÍA");
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Acción: Personal de conserjería notificado.");
    }
}
