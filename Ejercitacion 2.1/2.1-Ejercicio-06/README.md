La clase GestorTema implementa el patrón Singleton mediante un atributo estático inicialmente en null, un constructor privado y el método getInstancia(), que crea la instancia únicamente cuando se solicita por primera vez. De esta manera, todas las vistas de la aplicación pueden acceder al mismo objeto y compartir el estado del tema visual.

Los atributos temaActual, colorFondo y colorTexto son privados para impedir modificaciones directas desde otras clases. El método cambiarTema() permite seleccionar entre los temas claro y oscuro y actualiza sus colores correspondientes. Los métodos de consulta permiten obtener el estado y los colores actuales.

Por último, los métodos sincronizados coordinan el acceso concurrente a los datos. El main comprueba que, al cambiar el tema desde una referencia, otra referencia a la misma instancia obtiene los valores actualizados.

<img width="326" height="209" alt="image" src="https://github.com/user-attachments/assets/6ba82c3d-4f9a-4f74-bf28-a345833406bf" />
