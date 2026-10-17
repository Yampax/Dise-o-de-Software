## Creación de la instancia única

Para implementar Singleton, se declara el atributo instancia de la siguiente manera:

private static final GestorConexion instancia = new GestorConexion();

Este atributo almacena la única instancia de la clase. Se utiliza private para impedir el acceso directo desde otras clases, static porque pertenece a la clase y final para evitar que la referencia sea reemplazada por otro objeto.

De esta manera, cada vez que se necesite acceder al gestor de conexiones, se utilizará la misma instancia en lugar de crear una nueva.

## Uso del constructor privado

El constructor GestorConexion() se declara como private para impedir que otras clases puedan crear objetos de esta clase utilizando la palabra clave new.

Dentro del constructor se establece la variable conexionActiva en true y se muestra un mensaje indicando que la conexión a la base de datos fue establecida.

Decidí utilizar este mecanismo para simular la apertura de una única conexión al iniciar el gestor. Como el constructor solo se ejecuta al crear la instancia, el mensaje aparece una sola vez durante la ejecución normal del programa.

 ## Control del estado de la conexión

Para representar el estado de la conexión, se utiliza el atributo:

private boolean conexionActiva;

Esta variable indica si la conexión está activa o no. Se declara como private para evitar que otras clases modifiquen directamente su valor.

En el constructor se establece en true, lo que representa que la conexión fue abierta correctamente. Luego, los métodos que realizan las operaciones comprueban este valor antes de simular su ejecución.

De esta forma, se incorpora un control básico para evitar que se realicen operaciones cuando la conexión no se encuentra activa. En este ejercicio, la conexión permanece activa durante toda la ejecución, ya que no se implementó un método para cerrarla.

## Método getInstancia()

El método getInstancia() permite obtener la instancia única del gestor de conexiones.

Se declara como public para que pueda utilizarse desde otras clases y como static para poder llamarlo directamente mediante el nombre de la clase, sin necesidad de crear un objeto previamente.

El método devuelve el atributo instancia, por lo que todas las llamadas realizadas a través de él obtienen una referencia al mismo objeto.

Este método es fundamental para el funcionamiento del patrón Singleton, porque proporciona un único punto de acceso al gestor.

## Método consultar()

El método consultar(String consulta) permite simular la ejecución de una consulta a la base de datos. Recibe como parámetro una cadena de texto que representa la consulta que se desea realizar.

Dentro del método se comprueba si conexionActiva es true. Si la conexión está activa, se muestra un mensaje indicando que se está ejecutando la consulta. En caso contrario, se informa que no existe una conexión activa.

Por ejemplo, en el programa se utiliza la consulta SELECT * FROM clientes, que en SQL se emplearía para obtener los registros de la tabla de clientes.

El objetivo de este método es demostrar cómo se pueden centralizar las operaciones de consulta utilizando el mismo gestor de conexiones.

## Método actualizar()

El método actualizar(String operacion) funciona de manera similar al método anterior, pero está pensado para representar operaciones que modifican los datos de la base de datos.

Recibe como parámetro una cadena que describe la actualización que se desea realizar y comprueba si la conexión está activa antes de mostrar el mensaje correspondiente.

En el ejemplo se utiliza una instrucción UPDATE para representar la modificación del nombre de un cliente.

La separación entre consultar() y actualizar() permite diferenciar los dos tipos de operaciones solicitadas en el ejercicio. Sin embargo, en esta implementación ambas son simuladas: el programa no ejecuta realmente las instrucciones SQL.

## Método isConexionActiva()

Este método devuelve el valor de la variable conexionActiva. Su finalidad es permitir consultar el estado de la conexión sin acceder directamente al atributo privado.

Se utiliza para comprobar si el gestor considera que la conexión se encuentra activa. De esta manera, se mantiene el encapsulamiento y se facilita la verificación del estado desde otras partes del programa.

## Prueba del funcionamiento en el método main

Dentro del método main se obtiene una instancia del gestor mediante GestorConexion.getInstancia() y se almacena en la variable gestor1.

Luego, se utilizan los métodos consultar() y actualizar() para simular las operaciones sobre la base de datos.

Posteriormente, se vuelve a llamar a getInstancia() y se guarda el resultado en gestor2. Finalmente, se utiliza la expresión gestor1 == gestor2 para comprobar si ambas variables hacen referencia al mismo objeto.

Si el resultado es true, significa que las dos variables apuntan a la misma instancia, lo que permite verificar el comportamiento esperado del patrón Singleton.

Por último, se consulta el estado de la conexión mediante isConexionActiva() para comprobar que el gestor mantiene la conexión activa.

<img width="653" height="229" alt="image" src="https://github.com/user-attachments/assets/77c08f3e-8aac-4ced-ae98-347044ebbaed" />
