En este ejercicio, la aplicación del patrón Observer se encuentra en la clase "MarcadorPuntuacion", que funciona como sujeto observable y se encarga de administrar la puntuación del jugador.

Se creó la interfaz "ObservadorPuntuacion", que establece el método "actualizar()" que deben implementar los componentes interesados en recibir los cambios. Por otro lado, la interfaz "Sujeto" define los métodos necesarios para suscribir, desuscribir y notificar a los observadores.

Las clases "PantallaJuego" y "SistemaRecords" implementan la interfaz "ObservadorPuntuacion". Cada una recibe el nuevo valor de la puntuación y realiza una acción independiente: la primera muestra los puntos en pantalla y la segunda registra el resultado.

Cuando se ejecuta el método "sumarPuntos()", el marcador modifica la puntuación y llama a "notificar()", que recorre la lista de observadores y les envía el nuevo valor automáticamente.

Además, se permite agregar o quitar observadores durante la ejecución del programa, por lo que los componentes pueden dejar de recibir actualizaciones sin modificar la lógica del marcador.

De esta manera, se evita que la clase encargada de administrar los puntos dependa directamente de la pantalla o del sistema de récords. Esto permite mantener los componentes desacoplados y facilita incorporar nuevos observadores en el futuro.

<img width="400" height="376" alt="image" src="https://github.com/user-attachments/assets/e7af0628-f937-4e57-b2da-226804057fe6" />
