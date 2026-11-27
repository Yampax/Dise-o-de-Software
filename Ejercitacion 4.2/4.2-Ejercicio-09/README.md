En este ejercicio se implementó un bus de eventos centralizado utilizando el patrón Observer para simular un sistema de monitoreo de servidores. El objetivo fue permitir que diferentes servidores publiquen alertas y que los módulos interesados puedan recibirlas sin depender directamente entre sí.

Se creó la clase `Evento`, que contiene el tipo de incidencia, su severidad y una descripción. La interfaz `ObservadorEvento` establece el método que deben implementar los módulos que reciben estos eventos.

La clase `BusEventos` es la encargada de gestionar las suscripciones y distribuir las alertas. Para organizar a los observadores se utilizó un `ConcurrentHashMap`, que permite almacenar las listas según el tipo de evento. De esta forma, cuando se publica una alerta, el bus busca únicamente a los observadores registrados para esa categoría.

También se utilizó `CopyOnWriteArrayList` para permitir modificaciones en las suscripciones de forma segura mientras se recorren las listas, y `ExecutorService` para realizar las notificaciones de manera asíncrona.

Además, cada observador se ejecuta dentro de un bloque `try-catch`, lo que permite controlar las excepciones individuales y evitar que el fallo de un módulo interrumpa las notificaciones de los demás.

Con esta implementación se logra un sistema desacoplado, donde los servidores solamente publican eventos y los módulos pueden suscribirse o desuscribirse según sus necesidades, sin modificar la lógica de los servidores ni del bus de eventos.

<img width="365" height="251" alt="image" src="https://github.com/user-attachments/assets/d2b5b5fe-82d0-40c2-b1bf-1f75dd52e22e" />
<img width="466" height="292" alt="image" src="https://github.com/user-attachments/assets/87b0799f-7261-4ee8-a05d-73e9e0a7d91b" />
<img width="646" height="339" alt="image" src="https://github.com/user-attachments/assets/67b16e75-6e3d-419b-b7ce-70714a2c3eef" />

