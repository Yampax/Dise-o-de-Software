La clase GestorConexion implementa el patrón Singleton mediante un atributo estático inicialmente en null, un constructor privado y el método getInstancia(), que crea el objeto únicamente cuando se solicita por primera vez. Esto permite centralizar la administración de la conexión y evitar la creación de múltiples gestores.

Los métodos conectar(), consultar(), actualizar() y desconectar() simulan las operaciones sobre una conexión compartida. El atributo conectado mantiene el estado de la conexión, mientras que los métodos sincronizados coordinan el acceso concurrente a ese estado.

Por último, el método main prueba la apertura de la conexión, la ejecución de operaciones, la reutilización de la instancia y el cierre de la conexión.

<img width="595" height="225" alt="image" src="https://github.com/user-attachments/assets/fb5f440e-b902-4db7-a74f-c15f94275f91" />
