import java.util.LinkedList;
import java.util.Queue;

public class CentralImpresion {

    private static CentralImpresion instancia = null;

    private final Queue<Documento> cola;

    // Representa un documento pendiente de impresión
    private static class Documento {
        private String nombreArchivo;
        private String autor;

        public Documento(String nombreArchivo, String autor) {
            this.nombreArchivo = nombreArchivo;
            this.autor = autor;
        }
    }

    // Constructor privado
    private CentralImpresion() {
        cola = new LinkedList<>();
        System.out.println("Central de impresión inicializada.");
    }

    // Obtiene la única instancia
    public static synchronized CentralImpresion getInstancia() {
        if (instancia == null) {
            instancia = new CentralImpresion();
        }
        return instancia;
    }

    // Agrega un documento a la cola
    public synchronized void encolarDocumento(
            String nombreArchivo, String autor) {

        if (nombreArchivo == null || nombreArchivo.isBlank()
                || autor == null || autor.isBlank()) {
            System.out.println(
                    "El nombre del archivo y el autor son obligatorios.");
            return;
        }

        Documento documento = new Documento(nombreArchivo, autor);
        cola.offer(documento);

        System.out.println("Documento agregado: " + nombreArchivo
                + " | Autor: " + autor);
    }

    // Procesa el siguiente documento de la cola
    public synchronized void imprimirSiguiente() {
        Documento documento = cola.poll();

        if (documento == null) {
            System.out.println("No hay documentos pendientes.");
            return;
        }

        System.out.println("Imprimiendo: " + documento.nombreArchivo
                + " | Autor: " + documento.autor);

        System.out.println("Impresión finalizada: "
                + documento.nombreArchivo);
    }

    // Procesa todos los documentos pendientes
    public void imprimirTodos() {
        while (true) {
            synchronized (this) {
                if (cola.isEmpty()) {
                    System.out.println(
                            "No quedan documentos pendientes.");
                    return;
                }

                imprimirSiguiente();
            }
        }
    }

    // Consulta la cantidad de documentos pendientes
    public synchronized int cantidadPendientes() {
        return cola.size();
    }

    public static void main(String[] args) {

        CentralImpresion central1 =
                CentralImpresion.getInstancia();

        central1.encolarDocumento("Informe.pdf", "Ana");
        central1.encolarDocumento("Factura.pdf", "Carlos");
        central1.encolarDocumento("Trabajo.docx", "Lucía");

        System.out.println("Documentos pendientes: "
                + central1.cantidadPendientes());

        central1.imprimirTodos();

        CentralImpresion central2 =
                CentralImpresion.getInstancia();

        System.out.println("¿Es la misma instancia? "
                + (central1 == central2));
    }
}

