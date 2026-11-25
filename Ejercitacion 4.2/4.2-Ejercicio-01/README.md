En este ejercicio se implementa el patrón Observer para simular el funcionamiento de un botón de interfaz gráfica que notifica automáticamente a los componentes interesados cuando es presionado.

La clase Boton funciona como sujeto observable. Se encarga de mantener una lista de observadores y ofrece métodos para registrarlos, eliminarlos y notificarles cuando se produce un evento de clic. De esta manera, el botón no necesita conocer las clases concretas que reciben las notificaciones.

La interfaz ObservadorClick establece el método alHacerClick(), que deben implementar todos los componentes que quieran reaccionar ante la pulsación del botón. En este caso, VentanaPrincipal y ContadorClicks implementan dicha interfaz, pero realizan acciones diferentes cuando reciben el evento.

La ventana principal simula la ejecución de una acción relacionada con el botón, mientras que el contador registra la cantidad de clics recibidos. Ambos observadores pueden estar suscritos simultáneamente, por lo que reciben automáticamente cada notificación que genera el botón.

También se incorporan los métodos suscribir() y desuscribir(), que permiten gestionar dinámicamente los observadores sin modificar la lógica interna del botón.

<img width="425" height="331" alt="image" src="https://github.com/user-attachments/assets/2af40a92-547b-4dfb-a683-207de6a4601d" />
