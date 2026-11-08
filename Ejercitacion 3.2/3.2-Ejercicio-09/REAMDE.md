Implemente el patrón Factory Method para desacoplar la creación de los conectores de sensores de la lógica principal del sistema. Para ello, definí una interfaz común que permite trabajar con diferentes protocolos de comunicación, como ModBus, I2C y SPI.

Creé una clase creadora abstracta y factorías concretas encargadas de generar cada tipo de conector. También incorporé un registro dinámico de factorías que permite agregar nuevos protocolos durante la ejecución sin modificar el gestor principal.

Para mejorar la seguridad y la concurrencia, utilicé estructuras como `ConcurrentHashMap`, `AtomicReference` y `LongAdder`. Además, incorporé estados de conexión, validaciones de parámetros y manejo de excepciones para controlar posibles fallos durante la inicialización de los sensores.

De esta manera, logré una arquitectura modular y extensible, que separa la creación de conectores, la gestión de sensores y el registro de métricas, aplicando principios SOLID.

<img width="348" height="341" alt="image" src="https://github.com/user-attachments/assets/f8334959-68e0-454f-ac25-a26fe401d536" />
