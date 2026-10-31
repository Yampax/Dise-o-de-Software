import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CatalogoL {
    private static CatalogoL instancia = null;

    private final List<Libro> libros;

    private CatalogoL() {
        libros = new ArrayList<>();
    }

    public static synchronized CatalogoL getInstancia() {
        if (instancia == null) {
            instancia = new CatalogoL();
        }
        return instancia;
    }

    public synchronized void agregarLibro(Libro libro) {

        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        if (libro.getCodigo() == null
                || libro.getCodigo().trim().isEmpty()) {
            throw new IllegalArgumentException("El código no puede estar vacío.");
        }

        if (libro.getTitulo() == null
                || libro.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("El título no puede estar vacío.");
        }

        if (libro.getCantidadEjemplares() < 0) {
            throw new IllegalArgumentException(
                    "La cantidad de ejemplares no puede ser negativa.");
        }

        for (Libro existente : libros) {
            if (existente.getCodigo().equalsIgnoreCase(libro.getCodigo())) {
                throw new IllegalArgumentException("El código ya existe.");
            }
        }

        libros.add(libro);
    }

    public synchronized List<Libro> buscarPorTitulo(String titulo) {
        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase()
                    .contains(titulo.toLowerCase())) {
                resultado.add(libro);
            }
        }

        return Collections.unmodifiableList(resultado);
    }

    public synchronized List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getAutor().toLowerCase()
                    .contains(autor.toLowerCase())) {
                resultado.add(libro);
            }
        }

        return Collections.unmodifiableList(resultado);
    }

    public synchronized void actualizarCantidad(
            String codigo, int nuevaCantidad) {

        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException(
                    "La cantidad no puede ser negativa.");
        }

        for (Libro libro : libros) {
            if (libro.getCodigo().equalsIgnoreCase(codigo)) {
                libro.setCantidadEjemplares(nuevaCantidad);
                return;
            }
        }

        System.out.println("No se encontró un libro con ese código.");
    }

    public synchronized List<Libro> obtenerCatalogo() {
        return Collections.unmodifiableList(new ArrayList<>(libros));
    }
}
