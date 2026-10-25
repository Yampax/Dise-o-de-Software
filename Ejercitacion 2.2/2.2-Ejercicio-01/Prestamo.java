public class Prestamo {

    private final Biblioteca configuracion;

    public Prestamo() {
        configuracion = Biblioteca.getInstancia();
    }

    public void mostrarConfiguracion() {
        System.out.println("Módulo de préstamos");
        System.out.println("Biblioteca: "
                + configuracion.getNombreBiblioteca());
        System.out.println("Máximo de libros: "
                + configuracion.getMaxLibrosPorSocio());
        System.out.println("Plazo de devolución: "
                + configuracion.getPlazoDevolucion() + " días");
    }

    public Biblioteca getConfiguracion() {
        return configuracion;
    }
}
