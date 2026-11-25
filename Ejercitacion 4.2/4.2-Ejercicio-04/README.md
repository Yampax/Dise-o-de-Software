En este ejercicio, el patrón Observer se aplica en la clase "Producto", que funciona como sujeto observable y administra el precio actual del artículo.

Se creó la interfaz "ObservadorPrecio", que define el método "actualizar()" y establece qué información deben recibir los componentes suscritos. También se implementó la interfaz "Sujeto", que contiene los métodos para suscribir, desuscribir y notificar a los observadores.

Las clases "NotificadorCorreo" y "PanelNotificaciones" implementan la interfaz "ObservadorPrecio". Ambas reciben los datos del cambio de precio, pero realizan acciones diferentes: una simula el envío de un correo electrónico y la otra muestra un aviso en el panel de notificaciones.

La lógica principal se encuentra en el método "actualizarPrecio()" de la clase "Producto". Este método compara el precio nuevo con el anterior y, solamente cuando el nuevo valor es menor, calcula el porcentaje de rebaja y ejecuta "notificar()" para informar a los observadores.

Además, los datos del producto se mantienen privados y se modifican mediante métodos controlados, evitando que otras clases puedan cambiar directamente su precio. También se permite suscribir y desuscribir canales de notificación durante la ejecución.

De esta manera, la clase "Producto" no depende directamente de los canales de comunicación y puede notificar a diferentes componentes sin conocer cómo procesan la información. Esto facilita incorporar nuevos medios de notificación sin modificar la lógica principal.
