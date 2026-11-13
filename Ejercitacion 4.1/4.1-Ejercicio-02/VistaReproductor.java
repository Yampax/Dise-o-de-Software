public class VistaReproductor implements Observador {

    private String nombre;

    public VistaReproductor(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String cancion, EstadoReproduccion estado) {
        System.out.println("Vista: " + nombre);
        System.out.println("Canción: " + cancion);
        System.out.println("Estado: " + estado);
        System.out.println("-------------------------");
    }
}
