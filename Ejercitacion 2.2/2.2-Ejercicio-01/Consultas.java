public class Consultas {

    private final Biblioteca configuracion;

    public Consultas() {
        configuracion = Biblioteca.getInstancia();
    }

    public void mostrarConfiguracion() {
        System.out.println("Módulo de consultas");
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

