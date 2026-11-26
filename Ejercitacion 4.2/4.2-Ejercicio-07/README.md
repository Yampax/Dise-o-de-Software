En este ejercicio, el patrón Observer se aplica mediante la clase `GestorCanales`, que funciona como un gestor central de eventos y administra las suscripciones de los usuarios a diferentes canales de video.

Se creó la interfaz `ObservadorVideo`, que establece el método `actualizar()` que deben implementar los usuarios interesados en recibir notificaciones. La clase `Video` permite encapsular los metadatos de cada publicación, como el identificador del canal, el nombre, el título y la descripción.

La clase `GestorCanales` utiliza un `ConcurrentHashMap` para almacenar los observadores asociados a cada identificador de canal, permitiendo mantener las suscripciones separadas. Cuando se publica un video, el método `publicarVideo()` busca únicamente los usuarios suscritos al canal correspondiente y les envía la notificación.

La clase `Usuario` implementa la interfaz `ObservadorVideo` y recibe los datos del video para simular una alerta emergente. Además, el sistema permite suscribirse y cancelar suscripciones durante la ejecución.

Para administrar las listas de suscriptores de manera segura, se utiliza `CopyOnWriteArrayList`, que permite realizar modificaciones sin provocar errores durante el recorrido de la colección.

De esta manera, los usuarios reciben únicamente las notificaciones de los canales que siguen, evitando enviar alertas innecesarias a otros usuarios. También se mantiene el sistema desacoplado, ya que el gestor no depende de las clases concretas de los usuarios y permite incorporar nuevos observadores sin modificar su lógica principal.

<img width="470" height="506" alt="image" src="https://github.com/user-attachments/assets/93c09e50-53ca-442a-a4b0-7d2b16671d85" />
<img width="404" height="378" alt="image" src="https://github.com/user-attachments/assets/b27a3fad-972a-4cbe-b34e-9ae2d957892e" />
<img width="448" height="494" alt="image" src="https://github.com/user-attachments/assets/c96ba7b3-0e35-4a65-96a0-227b2162c75f" />

