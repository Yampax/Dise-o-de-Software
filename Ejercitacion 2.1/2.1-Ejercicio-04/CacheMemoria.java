import java.util.HashMap;
import java.util.Map;

public class CacheMemoria {
    private CacheMemoria(){
        System.out.println("Caché en memoria inicializada.");
    }
    private static class InstanciaHolder{
        private static final CacheMemoria instancia = new CacheMemoria();
    }

    public static CacheMemoria getInstancia() {
        return InstanciaHolder.instancia;
    }

    private final Map<String, Object> cache = new HashMap<>();

    public synchronized void guardar(String clave, Object valor) {
        if (clave == null || clave.isBlank() || valor == null) {
            System.out.println("La clave y el valor deben ser válidos.");
            return;
        }

        cache.put(clave, valor);
        System.out.println("Elemento guardado: " + clave);
    }

    public synchronized Object obtener(String clave) {
        if (!existe(clave)) {
            System.out.println("La clave no existe en la caché.");
            return null;
        }

        return cache.get(clave);
    }

    public synchronized boolean existe(String clave) {
        return clave != null && cache.containsKey(clave);
    }

    public synchronized boolean actualizar(String clave, Object nuevoValor) {
        if (!existe(clave) || nuevoValor == null) {
            System.out.println("No se pudo actualizar el elemento.");
            return false;
        }

        cache.put(clave, nuevoValor);
        System.out.println("Elemento actualizado: " + clave);
        return true;
    }

    public synchronized boolean eliminar(String clave) {
        if (!existe(clave)) {
            System.out.println("No se pudo eliminar: la clave no existe.");
            return false;
        }

        cache.remove(clave);
        System.out.println("Elemento eliminado: " + clave);
        return true;
    }

    public synchronized int cantidadElementos() {
        return cache.size();
    }

    public static void main(String[] args) {
        CacheMemoria cache1 = CacheMemoria.getInstancia();

        cache1.guardar("usuario1", "Juan Pérez");
        cache1.guardar("usuario2", "María López");

        System.out.println(cache1.obtener("usuario1"));

        cache1.actualizar("usuario1", "Juan García");

        System.out.println(cache1.obtener("usuario1"));

        System.out.println("¿Existe usuario2? "
                + cache1.existe("usuario2"));

        cache1.eliminar("usuario2");

        CacheMemoria cache2 = CacheMemoria.getInstancia();

        System.out.println("¿Es la misma instancia? "
                + (cache1 == cache2));

        System.out.println("Elementos en caché: "
                + cache1.cantidadElementos());
    }
}
