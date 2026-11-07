Implemente el patrón Factory Method, con el objetivo de generar diferentes servicios de envío según el transportista seleccionado.

Creé la interfaz `ServicioEnvio`, que establece los métodos comunes para calcular el costo y el tiempo estimado de entrega.

Desarrollé las clases `EnvioPostal`, `EnvioExpreso` y `RetiroSucursal`, cada una con sus propias reglas de tarificación y plazos de entrega, considerando el peso y la distancia del pedido.

Implementé la clase abstracta `CreadorEnvio`, que declara el método de fábrica `crearServicio()`. Luego desarrollé los creadores concretos, encargados de instanciar cada servicio de transporte.

También creé `FabricaEnvios`, que centraliza la selección del método de envío y valida los datos del pedido y las condiciones geográficas necesarias antes de crear el servicio correspondiente.

Finalmente, en `Main` solicito el método de envío indicando su tipo y los datos del pedido, sin crear directamente los servicios concretos.

Considero que esta implementación permite separar la creación de los servicios de transporte de sus cálculos particulares, facilita agregar nuevos transportistas y evita que el código cliente tenga que conocer los detalles internos de cada uno.

<img width="335" height="280" alt="image" src="https://github.com/user-attachments/assets/bb19c027-037e-41d9-83f2-ebe105b0956f" />
