public class Pantalla implements Observador {

    private String nombre;

    public Pantalla(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(double temperatura) {

        System.out.println(
            nombre + " - Temperatura actual: "
            + temperatura + " °C"
        );

    }
}
