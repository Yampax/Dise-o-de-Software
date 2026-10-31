import java.util.ArrayList;
import java.util.List;

public class Administrador {

    private static Administrador instancia = null;

    private final List<Prestamos> prestamosActivos;

    private Administrador() {
        prestamosActivos = new ArrayList<>();
    }

    public static synchronized Administrador getInstancia() {
        if (instancia == null) {
            instancia = new Administrador();
        }
        return instancia;
    }

    public void registrarPrestamo(String idEjemplar, String socio) {

        if (idEjemplar == null || idEjemplar.trim().isEmpty()
                || socio == null || socio.trim().isEmpty()) {
            System.out.println("Los datos del préstamo son obligatorios.");
            return;
        }

        for (Prestamos prestamo : prestamosActivos) {
            if (prestamo.getIdEjemplar().equalsIgnoreCase(idEjemplar)) {
                System.out.println("El ejemplar ya se encuentra prestado.");
                return;
            }
        }

        prestamosActivos.add(new Prestamos(idEjemplar, socio));
        System.out.println("Préstamo registrado correctamente.");
    }

    public void registrarDevolucion(String idEjemplar) {

        for (Prestamos prestamo : prestamosActivos) {
            if (prestamo.getIdEjemplar().equalsIgnoreCase(idEjemplar)) {
                prestamosActivos.remove(prestamo);
                System.out.println("Devolución registrada correctamente.");
                return;
            }
        }

        System.out.println("No existe un préstamo activo para ese ejemplar.");
    }

    public List<Prestamos> consultarPrestamosSocio(String socio) {

        List<Prestamos> resultado = new ArrayList<>();

        for (Prestamos prestamo : prestamosActivos) {
            if (prestamo.getSocio().equalsIgnoreCase(socio)) {
                resultado.add(prestamo);
            }
        }

        return resultado;
    }
}

