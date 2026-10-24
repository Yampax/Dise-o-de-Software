La clase ColectorMetricas implementa el patrón Singleton mediante un atributo estático inicialmente en null, un constructor privado y el método getInstancia(), que crea la instancia únicamente cuando se solicita por primera vez. Así, todos los componentes de la aplicación comparten el mismo colector.

La estructura ConcurrentHashMap almacena las métricas, mientras que LongAdder permite acumular operaciones y latencias con menor contención entre hilos. LongAccumulator registra la latencia máxima. El método registrar() incorpora nuevas mediciones y exportarResumen() genera un informe con los contadores y las latencias acumuladas.

Para controlar el consumo de memoria, se limita la cantidad de métricas individuales a 999 y se reserva una entrada adicional para agrupar las métricas nuevas que superen ese límite. De esta forma, se evita el crecimiento ilimitado de claves sin descartar sus mediciones agregadas.

<img width="774" height="196" alt="image" src="https://github.com/user-attachments/assets/731b5acd-a748-4899-b961-22c6e89bf203" />
