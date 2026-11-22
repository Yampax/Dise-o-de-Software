public class CentralAlarmas implements Observador {

    @Override
    public void actualizar(String ubicacion, String mensaje) {
        System.out.println("\nCENTRAL DE ALARMAS");
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Acción: ¡Alarma de incendio activada!");
    }
}
