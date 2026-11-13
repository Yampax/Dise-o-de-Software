En este ejercicio se desarrolla un reproductor multimedia que permite modificar la canción actual y su estado de reproducción, que puede ser reproduciendo, pausado o detenido.

El funcionamiento del patrón Observer se aplica mediante la relación entre el reproductor y las distintas vistas de la aplicación. La interfaz Observador establece el método actualizar(), que deben implementar los componentes visuales para recibir los cambios. Por otro lado, la interfaz Sujeto define los métodos necesarios para suscribir, desuscribir y notificar a los observadores.

La clase Reproductor es la encargada de mantener la información de la canción y el estado actual. También administra la lista de observadores mediante CopyOnWriteArrayList, que permite recorrer la colección de forma segura ante modificaciones concurrentes. Cuando se cambia la canción o el estado de reproducción, se ejecuta el método notificar(), que recorre los componentes suscritos y les envía la información actualizada.

La clase VistaReproductor representa los tres componentes visuales: la barra inferior, la ventana flotante y el widget principal. Como todos implementan la interfaz Observador, pueden recibir las mismas notificaciones sin que el reproductor necesite conocer los detalles particulares de cada vista.

De esta manera, las vistas no necesitan consultar constantemente al reproductor para conocer su estado, sino que reaccionan automáticamente cuando reciben una notificación. Además, es posible agregar o quitar componentes de la lista de suscripciones sin modificar la lógica principal del reproductor.

Con esta implementación se demuestra cómo Observer permite mantener sincronizados varios componentes, reducir el acoplamiento entre las clases y facilitar la incorporación de nuevas vistas.

<img width="228" height="527" alt="image" src="https://github.com/user-attachments/assets/559463e6-a1ed-4b32-bd8c-868a88958239" />

<img width="233" height="462" alt="image" src="https://github.com/user-attachments/assets/46a03626-e5ae-458a-8226-660ad223f0e0" />
