En este ejercicio se desarrolla un sistema de notificación de cambios en perfiles de riesgo mediante el patrón Observer, simulando una plataforma bancaria en la que diferentes subsistemas regulatorios deben recibir información sobre las modificaciones realizadas en los clientes.

La clase GestorRiesgo funciona como sujeto observable. Es responsable de mantener el perfil actual del cliente, administrar la lista de observadores y comunicar los cambios realizados. Para evitar dependencias directas, los módulos externos no son invocados mediante referencias a clases concretas, sino que implementan la interfaz ObservadorRegulatorio.

La clase CambioRiesgo encapsula la información de cada modificación, incluyendo el identificador del cliente, el perfil anterior, el nuevo perfil y la fecha. De esta manera, todos los observadores reciben los mismos datos del evento.

Los observadores concretos son CumplimientoLegal, PrevencionLavado y ReportesRegulatorios. Cada uno tiene una responsabilidad independiente y procesa la información de acuerdo con su función dentro del sistema.

Para controlar la concurrencia, la lista de observadores utiliza CopyOnWriteArrayList, que permite realizar operaciones de suscripción y eliminación de manera segura mientras se recorre la colección. Además, el método cambiarPerfil() está sincronizado para asegurar que los cambios de estado y sus notificaciones se ejecuten de forma secuencial y controlada.

También se incorpora un bloque try-catch individual para cada observador. Esto permite aislar los errores de procesamiento: si un subsistema presenta una excepción, se registra la incidencia y se continúa con los demás observadores, evitando que un fallo individual interrumpa todo el proceso.

Finalmente, la clase RegistroAuditoria almacena los resultados de las notificaciones en una lista inmutable. Esto permite consultar qué observadores procesaron correctamente el cambio y cuáles presentaron incidencias, conservando la información obtenida durante esa ejecución.

<img width="1220" height="314" alt="image" src="https://github.com/user-attachments/assets/3db2a28f-4c32-4ea8-adbb-52d29dc1f005" />
