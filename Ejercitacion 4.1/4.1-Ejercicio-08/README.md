En este ejercicio se realiza una refactorización de un sistema de gestión de tareas que originalmente tenía un alto acoplamiento entre sus componentes. El problema se encontraba en que la clase encargada de administrar las tareas dependía directamente de los módulos de correo electrónico y estadísticas. Esto provocaba que cualquier modificación o incorporación de nuevos módulos requiriera modificar también la lógica principal.

Para solucionar este problema, se implementa el patrón Observer, utilizando interfaces que permiten separar la gestión de las tareas de los módulos que reciben las notificaciones.

La clase Tarea funciona como sujeto observable y es responsable de administrar su propio estado. También mantiene una lista de observadores registrados. Cuando se ejecuta el método cambiarEstado(), guarda el estado anterior, actualiza el nuevo estado y llama al método notificar() para comunicar el cambio.

La interfaz ObservadorTarea establece el método actualizar(), que deben implementar todos los módulos interesados en recibir información sobre las modificaciones de una tarea. De esta manera, NotificadorCorreo y ModuloEstadisticas implementan la misma interfaz, pero cada uno realiza una acción diferente al recibir una notificación.

Además, los métodos suscribir() y desuscribir() permiten agregar o quitar observadores dinámicamente, sin necesidad de modificar la clase Tarea.

La implementación también aplica inversión de control, porque la clase Tarea no decide qué módulos concretos deben ejecutarse. Solamente comunica los cambios a través de una abstracción, mientras que los módulos externos se encargan de reaccionar al evento.

De esta forma, se elimina la dependencia directa entre la lógica principal y los servicios específicos, se mejora la separación de responsabilidades y se facilita la incorporación de nuevos observadores sin modificar el funcionamiento interno de la clase Tarea.

<img width="825" height="160" alt="image" src="https://github.com/user-attachments/assets/5ede2ade-e103-415c-a000-499952758ae4" />
