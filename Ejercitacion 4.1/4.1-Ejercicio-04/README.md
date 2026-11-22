En este ejercicio se desarrolla un sistema de control de inventario que permite detectar automáticamente cuando la cantidad de unidades disponibles de un producto desciende por debajo de un mínimo establecido.

El patrón Observer se aplica mediante la relación entre la clase Producto y los departamentos que reciben las alertas. La interfaz Observador establece el método actualizar(), que implementan los departamentos interesados en conocer los cambios del inventario. Por otro lado, la interfaz Sujeto define los métodos para suscribir, desuscribir y notificar a los observadores.

La clase Producto es la encargada de administrar la información del inventario, como el nombre, la cantidad disponible y el umbral mínimo. Estos atributos son privados para proteger los datos y evitar que otras clases puedan modificarlos directamente. Las ventas se realizan mediante el método vender(), que valida la cantidad solicitada y actualiza el stock.

Después de cada venta, el producto comprueba si la cantidad disponible es inferior al umbral mínimo. Cuando se cumple esta condición, ejecuta el método notificar(), que envía el nombre del producto y el stock actual a los departamentos que están suscritos.

Las clases DepartamentoCompras y DepartamentoMarketing implementan la interfaz Observador. Ambas reciben la misma información, pero realizan acciones diferentes: Compras puede evaluar la necesidad de reabastecer el producto, mientras que Marketing puede analizar la posibilidad de realizar una campaña de liquidación.

Además, el sistema permite registrar y eliminar observadores durante la ejecución, por lo que los departamentos pueden dejar de recibir notificaciones sin modificar la clase principal del producto.

