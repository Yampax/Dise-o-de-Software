En este ejercicio, el patrón Observer se aplica en la clase "Producto", que funciona como sujeto observable y administra el precio actual del artículo.

Se creó la interfaz "ObservadorPrecio", que define el método "actualizar()" y establece qué información deben recibir los componentes suscritos. También se implementó la interfaz "Sujeto", que contiene los métodos para suscribir, desuscribir y notificar a los observadores.

Las clases "NotificadorCorreo" y "PanelNotificaciones" implementan la interfaz "ObservadorPrecio". Ambas reciben los datos del cambio de precio, pero realizan acciones diferentes: una simula el envío de un correo electrónico y la otra muestra un aviso en el panel de notificaciones.

La lógica principal se encuentra en el método "actualizarPrecio()" de la clase "Producto". Este método compara el precio nuevo con el anterior y, solamente cuando el nuevo valor es menor, calcula el porcentaje de rebaja y ejecuta "notificar()" para informar a los observadores.

Además, los datos del producto se mantienen privados y se modifican mediante métodos controlados, evitando que otras clases puedan cambiar directamente su precio. También se permite suscribir y desuscribir canales de notificación durante la ejecución.

De esta manera, la clase "Producto" no depende directamente de los canales de comunicación y puede notificar a diferentes componentes sin conocer cómo procesan la información. Esto facilita incorporar nuevos medios de notificación sin modificar la lógica principal.

<img width="426" height="453" alt="image" src="https://github.com/user-attachments/assets/88caff51-71c7-4abe-9661-0ef6ff26b378" />
<img width="428" height="490" alt="image" src="https://github.com/user-attachments/assets/8d727da0-c22b-4eba-b6ad-d579978676a1" />
<img width="424" height="208" alt="image" src="https://github.com/user-attachments/assets/a8aad277-67db-44df-864f-61e9782e1f25" />
