En este ejercicio se desarrolla un sistema de auditoría que permite registrar automáticamente las operaciones importantes realizadas sobre los empleados, como las altas, bajas o modificaciones de sus datos.

El patrón Observer se aplica mediante una relación entre el sistema central de empleados y los módulos encargados de recibir los eventos de auditoría. La interfaz Observador define el método actualizar(), que deben implementar los distintos auditores para recibir los mensajes. Por otro lado, la interfaz Sujeto establece los métodos necesarios para registrar, eliminar y notificar a los observadores.

La clase encargada de gestionar los empleados contiene la lógica de negocio y genera una notificación cada vez que se realiza una operación crítica. Cuando ocurre una modificación, se envía un mensaje a todos los observadores registrados, sin necesidad de llamar directamente a las clases que escriben en consola o en archivos.

Los módulos de auditoría implementan la interfaz Observador. Uno se encarga de mostrar los mensajes en la consola y el otro de guardarlos en un archivo de bitácora. De esta manera, ambos reciben el mismo evento, pero cada uno realiza su tarea de forma independiente.

Además, el sistema permite suscribir o desuscribir auditores durante la ejecución, por lo que se pueden agregar nuevos receptores sin modificar la lógica principal de los empleados.


<img width="856" height="88" alt="image" src="https://github.com/user-attachments/assets/77919ade-a79f-4110-aa5d-90a4761c9d8a" />
