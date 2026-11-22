public class SistemaRociadores implements Observador {

    @Override
    public void actualizar(String ubicacion, String mensaje) {
        System.out.println("\nSISTEMA DE ROCIADORES");
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("Acción: ¡Rociadores activados!");
    }
}
