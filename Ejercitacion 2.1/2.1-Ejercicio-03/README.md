La clase Logger implementa el patrón Singleton mediante un atributo estático inicialmente en null, un constructor privado y el método getInstancia(), que crea una única instancia cuando se solicita por primera vez. Así, todas las clases de la aplicación pueden utilizar el mismo registrador sin instanciarlo directamente.

Los métodos info(), warning() y error() permiten registrar mensajes según su nivel de severidad. Cada registro incluye automáticamente la fecha y hora, se muestra por consola y se guarda en el archivo aplicacion.log. El archivo se abre en modo de anexado para conservar los registros anteriores.

El método registrar() es sincronizado para coordinar las escrituras realizadas desde distintos hilos que utilizan la misma instancia. Finalmente, el main prueba los tres niveles de registro y verifica que dos referencias obtenidas mediante getInstancia() apunten al mismo objeto.

<img width="568" height="182" alt="image" src="https://github.com/user-attachments/assets/cffd90fc-3920-4f18-86a6-74c5618ece7c" />
