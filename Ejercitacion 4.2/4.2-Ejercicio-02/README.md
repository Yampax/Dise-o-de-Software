En esta implementación, la clase MonitorRed funciona como sujeto observable, ya que se encarga de mantener el estado de la conexión y administrar los componentes que desean recibir sus cambios.

Para establecer la comunicación se creó la interfaz ObservadorRed, que define el método actualizar(). De esta manera, los componentes interesados deben implementar un mismo contrato, sin que el monitor necesite conocer sus clases concretas.

Las clases IconoConexion y TextoEstado implementan esta interfaz y representan dos formas diferentes de mostrar la información. Cuando el monitor modifica el estado mediante cambiarEstado(), ejecuta el método notificar(), que recorre los observadores registrados y les comunica el nuevo estado.

También se incorporaron los métodos suscribir() y desuscribir() para permitir agregar o quitar componentes interesados en las notificaciones. Para administrar la lista se utilizó CopyOnWriteArrayList, que permite realizar operaciones de suscripción y eliminación de forma segura durante la iteración.

De esta forma, los componentes visuales no necesitan consultar constantemente el estado de la red. Reciben las actualizaciones automáticamente cuando ocurre un cambio, manteniendo sus responsabilidades separadas y evitando el acoplamiento entre el monitor y las representaciones visuales.

<img width="356" height="332" alt="image" src="https://github.com/user-attachments/assets/6afedcf9-3eb3-4897-99fe-13cbcb8128bd" />
