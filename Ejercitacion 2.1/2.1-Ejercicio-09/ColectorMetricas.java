import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

public class ColectorMetricas {

    private static ColectorMetricas instancia = null;

    private static final int MAX_METRICAS = 1000;
    private static final String OTRAS = "OTRAS_METRICAS";

    private final ConcurrentMap<String, Metrica> metricas;

    // Representa los datos acumulados de una métrica
    private static class Metrica {
        private final LongAdder cantidad = new LongAdder();
        private final LongAdder latenciaTotal = new LongAdder();

        private final LongAccumulator latenciaMaxima =
                new LongAccumulator(Long::max, 0);

        public void registrar(long latencia) {
            cantidad.increment();
            latenciaTotal.add(latencia);
            latenciaMaxima.accumulate(latencia);
        }

        public String resumen() {
            long total = cantidad.sum();
            long latencia = latenciaTotal.sum();
            long maximo = latenciaMaxima.get();

            double promedio = total == 0
                    ? 0
                    : (double) latencia / total;

            return "operaciones=" + total
                    + ", latenciaPromedio=" + promedio + " ms"
                    + ", latenciaMaxima=" + maximo + " ms";
        }
    }

    // Constructor privado
    private ColectorMetricas() {
        metricas = new ConcurrentHashMap<>();
        System.out.println("Colector de métricas inicializado.");
    }

    // Obtiene la única instancia
    public static synchronized ColectorMetricas getInstancia() {
        if (instancia == null) {
            instancia = new ColectorMetricas();
        }
        return instancia;
    }

    // Obtiene o crea una métrica sin superar el límite
    private Metrica obtenerMetrica(String nombre) {
        Metrica metrica = metricas.get(nombre);

        if (metrica != null) {
            return metrica;
        }

        synchronized (this) {
            metrica = metricas.get(nombre);

            if (metrica != null) {
                return metrica;
            }

            if (metricas.size() < MAX_METRICAS - 1) {
                metrica = new Metrica();
                metricas.put(nombre, metrica);
                return metrica;
            }

            // Conserva las métricas adicionales en un grupo común
            return metricas.computeIfAbsent(
                    OTRAS, clave -> new Metrica());
        }
    }

    // Registra una operación y su latencia en milisegundos
    public void registrar(String nombre, long latenciaMs) {
        if (nombre == null || nombre.isBlank()
                || nombre.equals(OTRAS) || latenciaMs < 0) {
            System.out.println("Los datos de la métrica no son válidos.");
            return;
        }

        obtenerMetrica(nombre).registrar(latenciaMs);
    }

    // Registra un incremento de contador sin latencia
    public void incrementar(String nombre) {
        registrar(nombre, 0);
    }

    // Exporta un resumen consolidado
    public String exportarResumen() {
        Map<String, Metrica> copia = new TreeMap<>(metricas);
        StringBuilder resumen = new StringBuilder();

        resumen.append("=== RESUMEN DE MÉTRICAS ===\n");

        for (Map.Entry<String, Metrica> entrada : copia.entrySet()) {
            resumen.append(entrada.getKey())
                    .append(": ")
                    .append(entrada.getValue().resumen())
                    .append("\n");
        }

        return resumen.toString();
    }

    public static void main(String[] args) {
        ColectorMetricas colector1 =
                ColectorMetricas.getInstancia();

        colector1.registrar("solicitudes_http", 120);
        colector1.registrar("solicitudes_http", 85);
        colector1.registrar("consultas_bd", 40);
        colector1.incrementar("errores");

        ColectorMetricas colector2 =
                ColectorMetricas.getInstancia();

        colector2.registrar("solicitudes_http", 100);

        System.out.println(colector1.exportarResumen());

        System.out.println("¿Es la misma instancia? "
                + (colector1 == colector2));
    }
}
