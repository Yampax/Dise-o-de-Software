## Importación de las clases
Al principio del código se importan tres clases que son necesarias para su funcionamiento:

-  InputStream: se utiliza para leer el contenido del archivo de configuración.

-  IOException: permite manejar posibles errores que ocurran durante la lectura del archivo.

-  Properties: sirve para almacenar y consultar los datos del archivo mediante pares de clave y valor.

Estas clases permiten trabajar con el archivo de configuración de una manera más sencilla y organizada.

## Creación de la instancia única

En el código se declara el siguiente atributo:

private static final Configuración instancia = new Configuración();

Este atributo es el que permite implementar el patrón Singleton. Se utiliza private para que no se pueda acceder directamente desde otras clases, static porque pertenece a la clase y no a un objeto particular, y final para evitar que la referencia sea reemplazada por otra instancia.

De esta manera, se crea un único objeto que podrá ser utilizado cada vez que se necesite acceder a la configuración.

## Uso del constructor privado

El constructor de la clase se declara como private. Esto impide que se puedan crear objetos de Configuración desde otras clases utilizando la palabra clave new.

Esta decisión es importante porque, si el constructor fuera público, se podrían crear varias instancias y no se estaría cumpliendo con el objetivo del patrón Singleton.

Además, dentro del constructor se realiza la lectura del archivo config.properties, por lo que la configuración se carga cuando se inicializa la instancia.

## Lectura del archivo de configuración

Para leer el archivo se utiliza la siguiente instrucción:

Configuración.class.getResourceAsStream("/config.properties")

Esta instrucción permite buscar el archivo dentro de los recursos disponibles para la aplicación. Se utiliza este método para no depender de una ruta específica del disco, aunque es necesario que el archivo esté correctamente ubicado y disponible en los recursos del proyecto.

Después, el programa comprueba si la variable entrada es igual a null. Si esto ocurre, significa que no se encontró el archivo, por lo que se lanza una excepción con un mensaje que permite identificar el problema.

Si el archivo se encuentra, se utiliza propiedades.load(entrada) para leer su contenido y guardar los valores dentro del objeto Properties.

También se utiliza try-with-resources, que permite cerrar automáticamente el flujo de lectura una vez que termina de utilizarse. Esto evita dejar recursos abiertos innecesariamente.

## Manejo de errores

El código utiliza un bloque try-catch para controlar los posibles errores que puedan aparecer durante la lectura del archivo.

En particular, se captura la excepción IOException y se lanza una RuntimeException con el mensaje «No se pudo cargar la configuración».

Esto permite informar que ocurrió un problema durante la carga y conservar la excepción original para poder conocer su causa.

También se contempla el caso en el que el archivo no se encuentra. De esta forma, se pueden distinguir los problemas relacionados con la ubicación del archivo de aquellos que ocurren durante su lectura.

Si se produce un error al inicializar la instancia estática, Java puede generar una ExceptionInInitializerError, lo que impide utilizar normalmente la clase hasta que se corrija el problema de inicialización.

## Método getInstance()

El método getInstance() es el encargado de devolver la instancia de la clase.

Se declara como public para que pueda utilizarse desde otras clases y como static para poder llamarlo directamente sin necesidad de crear un objeto previamente.

Cada vez que se llama a este método, se devuelve la referencia almacenada en el atributo instancia. Por eso, no se crea un objeto nuevo en cada llamada, sino que se utiliza siempre la misma instancia.

## Método getPropiedad()

El método getPropiedad(String clave) permite obtener el valor de una propiedad del archivo de configuración a partir de su clave.

Por ejemplo, si se solicita la propiedad aplicacion.nombre, el método devuelve el valor que se encuentra asociado a esa clave en el archivo config.properties.

Decidí utilizar este método para poder consultar los datos sin acceder directamente al atributo propiedades. De esta forma, se mantiene el encapsulamiento de la clase y se facilita la consulta de los valores almacenados.

Si la clave no existe en el archivo, el método devuelve null.

## Prueba del funcionamiento del Singleton

En el método main se obtiene una instancia de la clase utilizando Configuración.getInstance(). Luego, se consultan e imprimen los valores de aplicacion.nombre y servidor.puerto.

Después, se vuelve a solicitar una instancia y se almacena en la variable config2.

Finalmente, se utiliza la expresión config1 == config2 para comprobar si ambas variables hacen referencia al mismo objeto. Si el resultado es true, significa que las dos variables apuntan a la misma instancia.

Esta prueba permite comprobar el funcionamiento del patrón Singleton y verificar que las llamadas al método getInstance() devuelven el mismo objeto.

<img width="349" height="144" alt="image" src="https://github.com/user-attachments/assets/bff63a6c-fc2c-4f1b-8396-7e06e9f50160" />

