Decidí implementar el patrón Factory Method para poder enviar notificaciones mediante diferentes canales sin que el código principal dependa directamente de las clases concretas de cada medio de envío.

Para ello, creé una interfaz llamada "Notificacion", que establece un método común para enviar mensajes. Luego, desarrollé las clases "NotificacionEmail" y "NotificacionSMS", que implementan dicho comportamiento según el canal correspondiente.

También incorporé una clase abstracta "CreadorNotificacion", encargada de declarar el método fábrica "crearNotificacion()". A partir de ella, desarrollé dos clases creadoras concretas que se encargan de instanciar el tipo de notificación correspondiente.

De esta manera, pude separar la creación de los objetos de la lógica de envío, permitiendo incorporar nuevos canales de notificación en el futuro sin modificar la estructura principal del sistema.
