En este ejercicio se desarrolla un motor de eventos basado en el patrón Observer, simulando una arquitectura de microservicios en la que distintos servicios pueden comunicarse sin depender directamente unos de otros.

La clase BusEventos funciona como intermediario centralizado. Su responsabilidad es administrar las suscripciones, recibir los eventos publicados y distribuirlos únicamente a los observadores interesados en cada tipo de mensaje.

La clase Evento representa la información que circula por el sistema. Contiene un identificador de tipo, como UsuarioRegistrado o PagoAprobado, y un payload que almacena los datos relacionados con ese evento.

La interfaz ObservadorEvento establece el método actualizar(), que deben implementar los servicios que quieran recibir notificaciones. Por ejemplo, ServicioNotificaciones y ServicioEstadisticas implementan esta interfaz y reaccionan de manera diferente según el evento recibido.

Los servicios ServicioUsuarios y ServicioPagos se encargan de publicar eventos a través del bus, sin conocer qué módulos los reciben ni cómo procesan la información. Esto permite mantener una separación entre los componentes que generan los eventos y los que reaccionan ante ellos.

Para mejorar el rendimiento y permitir el trabajo concurrente, el bus utiliza ConcurrentHashMap para organizar las suscripciones según el tipo de evento y CopyOnWriteArrayList para almacenar los observadores. Además, utiliza ExecutorService para procesar las publicaciones de manera asíncrona.

También se incorpora un mecanismo de manejo de excepciones dentro del proceso de notificación. Si un observador presenta un error al procesar un evento, el bus captura la excepción y continúa notificando a los demás, evitando que un fallo individual interrumpa el funcionamiento del resto de los servicios.

<img width="640" height="140" alt="image" src="https://github.com/user-attachments/assets/8d7d2362-2bf5-4ea8-9b50-6e05b25d4d26" />
