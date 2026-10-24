Utilicé el patrón Singleton para garantizar que exista una única instancia de Controlador, ya que varios controladores enviando comandos al mismo dispositivo podrían provocar errores.

El constructor privado impide crear objetos desde otras clases, mientras que getInstancia() permite acceder al mismo controlador. Para esto, utilicé la clase interna instanciaC, que crea la instancia recién cuando se solicita por primera vez.

Los atributos disponible y estado permiten controlar si el dispositivo puede recibir comandos y conocer su estado actual.

El método enviarComando() verifica que la instrucción sea válida y que el dispositivo esté disponible antes de simular su ejecución. Los métodos estaDisponible() y obtenerEstado() permiten consultar su disponibilidad y estado.

Por último, utilicé synchronized para evitar que varios hilos ejecuten simultáneamente los métodos sobre la misma instancia. En el método main() compruebo el funcionamiento y verifico que dos referencias obtenidas mediante getInstancia() apunten al mismo objeto.

<img width="338" height="162" alt="image" src="https://github.com/user-attachments/assets/9ec9b41e-0f0b-4751-9d85-93e18cfcf301" />
