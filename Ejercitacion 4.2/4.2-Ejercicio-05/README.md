En este ejercicio, el patrón Observer se aplica en la clase `SensorLuz`, que funciona como sujeto observable y se encarga de almacenar y actualizar el nivel de luminosidad exterior.

Se creó la interfaz `ObservadorLuz`, que establece el método `actualizar()` que deben implementar los dispositivos interesados en recibir los cambios. También se definió la interfaz `Sujeto`, que contiene los métodos necesarios para suscribir, desuscribir y notificar a los observadores.

Las clases `PersianasMotorizadas`, `LucesInteriores` y `AlarmaLuminosidad` implementan la interfaz `ObservadorLuz`. Cada una recibe el nivel de luminosidad y ejecuta una acción diferente según sus propias condiciones. Por ejemplo, las persianas se cierran cuando la luz es elevada, mientras que las luces interiores disminuyen su intensidad.

Cuando se ejecuta el método `actualizarLuminosidad()`, el sensor almacena el nuevo valor y llama a `notificar()`, que recorre la lista de observadores y les comunica el cambio.

Además, los dispositivos pueden suscribirse o desuscribirse durante la ejecución. Esto permite incorporar nuevos componentes automatizados sin modificar el código del sensor, ya que solamente necesitan implementar la interfaz correspondiente.

De esta manera, los dispositivos funcionan de manera independiente y el sensor no necesita conocer sus clases concretas ni las acciones que realizan. Esto permite mantener el sistema desacoplado y facilita su ampliación.

<img width="471" height="391" alt="image" src="https://github.com/user-attachments/assets/68f0a0f3-e247-4fdb-b4a6-dab49c10e180" />
