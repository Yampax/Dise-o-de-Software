La clase Controlador implementa el patrón Singleton porque tiene un constructor privado, un atributo estático que almacena la instancia y un método getInstancia() que crea el objeto únicamente si todavía no existe. Así, las llamadas posteriores devuelven la misma instancia.

El método getInstancia() utiliza synchronized para evitar que varios hilos creen instancias al mismo tiempo. Además, la clase permite consultar el estado del dispositivo, verificar su disponibilidad y enviar comandos.

Por último, el método main comprueba el funcionamiento del patrón al obtener dos referencias al controlador y verificar que ambas apuntan al mismo objeto.

<img width="283" height="120" alt="image" src="https://github.com/user-attachments/assets/50f4b170-4eb4-4fd9-9c55-9a04a44a472f" />
