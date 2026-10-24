
import java.util.HashMap;
import java.util.Map;

public class CacheMemoria {

    private static CacheMemoria instancia = null;

    private final Map<String, Object> cache;

    // Constructor privado
    private CacheMemoria() {
        cache = new HashMap<>();
        System.out.println("Caché inicializada.");
    }

    // Obtiener instancia única
    public static synchronized CacheMemoria getInstancia() {
        if (instancia == null) {
            instancia = new CacheMemoria();
        }
        return instancia;
    }

    // Almacena un elemento o actualiza uno existente
    public synchronized void guardar(String clave, Object valor) {
        if (clave == null || clave.isBlank() || valor == null) {
            System.out.println("La clave o el valor no son válidos.");
            return;
        }

        if (cache.containsKey(clave)) {
            System.out.println("Se actualizó el elemento: " + clave);
        } else {
            System.out.println("Se agregó el elemento: " + clave);
        }

        cache.put(clave, valor);
    }

    // Recupera un elemento
    public synchronized Object obtener(String clave) {
        if (clave == null || !cache.containsKey(clave)) {
            System.out.println("La clave no existe en la caché.");
            return null;
        }

        return cache.get(clave);
    }

    // Verifica si existe una clave
    public synchronized boolean existe(String clave) {
        return clave != null && cache.containsKey(clave);
    }

    // Elimina un elemento
    public synchronized void eliminar(String clave) {
        if (clave == null || !cache.containsKey(clave)) {
            System.out.println("No se encontró el elemento para eliminar.");
            return;
        }

        cache.remove(clave);
        System.out.println("Se eliminó el elemento: " + clave);
    }

    // Muestra la cantidad de elementos
    public synchronized int cantidadElementos() {
        return cache.size();
    }

    public static void main(String[] args) {

        CacheMemoria cache1 = CacheMemoria.getInstancia();

        cache1.guardar("usuario1", "Juan Pérez");
        cache1.guardar("usuario2", "María López");

        System.out.println("Usuario 1: "
                + cache1.obtener("usuario1"));

        cache1.guardar("usuario1", "Juan Pérez actualizado");

        System.out.println("Usuario 1 actualizado: "
                + cache1.obtener("usuario1"));

        System.out.println("¿Existe usuario2? "
                + cache1.existe("usuario2"));

        cache1.eliminar("usuario2");

        CacheMemoria cache2 = CacheMemoria.getInstancia();

        System.out.println("Cantidad de elementos: "
                + cache1.cantidadElementos());

        System.out.println("¿Es la misma instancia? "
                + (cache1 == cache2));
    }
}
