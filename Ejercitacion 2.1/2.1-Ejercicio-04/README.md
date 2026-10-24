La clase CacheMemoria implementa el patrón Singleton mediante un atributo estático inicialmente en null, un constructor privado y el método getInstancia(), que crea la instancia únicamente cuando se solicita por primera vez. De esta forma, toda la aplicación comparte una única caché.

La estructura HashMap se encuentra encapsulada dentro de la clase y solo puede modificarse mediante los métodos públicos. Estos permiten guardar, recuperar, actualizar, verificar y eliminar elementos. Los métodos utilizan synchronized para coordinar el acceso concurrente a la caché y evitar modificaciones simultáneas incompatibles.

Por último, el método main prueba las operaciones principales y verifica que dos referencias obtenidas mediante getInstancia() correspondan al mismo objeto.

<img width="388" height="249" alt="image" src="https://github.com/user-attachments/assets/2796a277-1c2d-4f08-840f-331f6bcd3c91" />
