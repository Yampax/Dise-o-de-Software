## Justificación de las importaciones

En primer lugar, incorporé las siguientes importaciones para utilizar las herramientas necesarias para el funcionamiento del sistema:

-  java.io.IOException: permite manejar posibles errores que ocurran durante las operaciones de entrada y salida, como cuando no es posible escribir en el archivo de registro.

-  java.nio.file.Files: proporciona métodos para trabajar con archivos. En este caso, se utiliza Files.writeString() para escribir cada mensaje en el archivo.

-  java.nio.file.Path: permite representar la ubicación del archivo donde se almacenarán los registros. Mediante Path.of("aplicacion.log"), se establece el nombre del archivo que utilizará el sistema.

-  java.nio.file.StandardOpenOption: permite especificar las opciones de escritura del archivo. Se utilizan CREATE, para crear el archivo si no existe, y APPEND, para agregar nuevos registros sin eliminar los anteriores.

-  java.time.LocalDateTime: permite obtener la fecha y hora actuales para identificar cuándo ocurrió cada evento.

-  java.time.format.DateTimeFormatter: permite definir el formato con el que se mostrará la fecha y hora de cada registro.

Estas importaciones permiten implementar un sistema de registro sin necesidad de utilizar bibliotecas externas.

## Implementación del patrón Singleton

Para garantizar que exista una única instancia de la clase Logger, utilicé los siguientes elementos:

private static final Logger instancia = new Logger();

Esta declaración crea una única instancia de la clase cuando se inicializa la clase Logger. El modificador private impide acceder directamente a esta variable desde otras clases, mientras que static permite que la instancia pertenezca a la clase y no a cada objeto creado. Por su parte, final impide que la referencia a esa instancia sea reemplazada por otra.

También declaré el constructor de la siguiente manera:

private Logger() {
    System.out.println("Sistema de registro inicializado.");
}

El constructor es privado para impedir que otras clases creen objetos mediante new Logger(). De esta manera, se evita la creación de instancias adicionales desde el exterior.

Para permitir el acceso al objeto existente, implementé el siguiente método:

public static Logger getInstancia() {
    return instancia;
}

Este método devuelve la instancia única del sistema de registro. Al ser estático, puede invocarse directamente desde la clase, sin necesidad de crear previamente un objeto.

En conjunto, estos elementos implementan el patrón Singleton y permiten que los diferentes componentes de la aplicación compartan el mismo gestor de registros.

## Registro de mensajes según su nivel de importancia

El sistema debe permitir registrar tres tipos de mensajes: información, advertencias y errores. Para ello, implementé tres métodos públicos:

public synchronized void info(String mensaje) {
    registrar("INFO", mensaje);
}

public synchronized void warning(String mensaje) {
    registrar("WARNING", mensaje);
}

public synchronized void error(String mensaje) {
    registrar("ERROR", mensaje);
}

Cada método recibe un mensaje de tipo String y lo envía al método privado registrar(), indicando el nivel correspondiente.

-  INFO: se utiliza para registrar información general, como el inicio correcto de la aplicación.

-  WARNING: permite informar sobre situaciones que requieren atención, aunque no necesariamente impiden continuar con la ejecución.

-  ERROR: se utiliza para registrar errores que afectan el funcionamiento de una operación.

Decidí utilizar métodos separados para que el código que utiliza el Logger pueda indicar claramente qué tipo de evento desea registrar. De esta manera, se facilita la lectura del programa y se mantiene una estructura organizada.

El modificador synchronized permite que, dentro de una misma instancia y en una misma ejecución de Java, solo un hilo a la vez ejecute cada uno de estos métodos. Esto ayuda a evitar que varios hilos registren mensajes simultáneamente y se interfieran durante la operación.

## Construcción del registro

Para centralizar el proceso de escritura, implementé el método privado registrar():

private void registrar(String nivel, String mensaje) {
  String fecha = LocalDateTime.now().format(formatoFecha);

  String registro = "[" + fecha + "] ["
            + nivel + "] " + mensaje + System.lineSeparator();

   // Escritura del registro en el archivo.
}

Este método recibe el nivel de importancia y el contenido del mensaje. Primero, obtiene la fecha y hora actuales mediante LocalDateTime.now() y las transforma al formato definido por formatoFecha.

El formato se establece mediante la siguiente declaración:

private final DateTimeFormatter formatoFecha =
        DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

De esta manera, la fecha se muestra con el día, mes, año, hora, minutos y segundos. Por ejemplo, un registro podría comenzar con 17/10/2026 12:30:15.

Después, el método construye una cadena que contiene la fecha, el nivel del mensaje y su contenido. System.lineSeparator() agrega el salto de línea correspondiente al sistema operativo, de modo que cada registro quede separado del siguiente.

Esta estructura permite identificar fácilmente cuándo ocurrió cada evento y cuál es su nivel de importancia.

## Almacenamiento de los registros en un archivo

Para conservar los mensajes, definí la ubicación del archivo:

private final Path archivo = Path.of("aplicacion.log");

El archivo se denomina aplicacion.log. Como se utiliza una ruta relativa, su ubicación depende del directorio de trabajo desde el cual se ejecuta el programa.

La escritura se realiza mediante el siguiente bloque:

Files.writeString(
        archivo,
        registro,
        StandardOpenOption.CREATE,
        StandardOpenOption.APPEND
);

Utilicé Files.writeString() para escribir el registro construido previamente. La opción CREATE hace que el archivo se cree si todavía no existe, mientras que APPEND agrega el nuevo contenido al final del archivo, conservando los registros anteriores.

Esta decisión permite mantener un historial de los eventos producidos durante las ejecuciones de la aplicación, en lugar de sobrescribir la información cada vez que se registra un mensaje.

También incorporé un bloque try-catch para manejar posibles errores de escritura:

try {
    // Escritura del registro.
} catch (IOException e) {
    System.err.println(
            "No se pudo guardar el registro: " + e.getMessage()
    );
}

Si ocurre un problema al escribir el archivo, la excepción IOException es capturada y se muestra un mensaje de error por la salida de error estándar. Así, el programa puede informar que el registro no pudo guardarse.

## Visualización de los mensajes por consola

Además de guardar la información en el archivo, incorporé la siguiente instrucción:

System.out.print(registro);

Esta línea muestra el mensaje por consola inmediatamente después de escribirlo en el archivo. Consideré conveniente utilizar ambos medios porque la consola permite observar los eventos durante la ejecución, mientras que el archivo conserva un historial que puede consultarse posteriormente.

De esta manera, el sistema cumple con la posibilidad de visualizar los registros y almacenarlos de forma persistente.

## Prueba de funcionamiento

Para comprobar el funcionamiento del Logger, utilicé el método main():

public static void main(String[] args) {
    Logger logger1 = Logger.getInstancia();
    logger1.info("La aplicación se inició correctamente.");
    logger1.warning("El espacio disponible es bajo.");
    logger1.error("No se pudo completar una operación.");
    Logger logger2 = Logger.getInstancia();
    System.out.println(
            "¿Es la misma instancia? " + (logger1 == logger2)
    );
}

En primer lugar, obtengo la instancia del Logger mediante getInstancia(). Luego, utilizo sus métodos para registrar un mensaje informativo, una advertencia y un error.

Posteriormente, vuelvo a solicitar la instancia y la almaceno en logger2. Finalmente, comparo ambas referencias mediante el operador ==.

Si el resultado es true, significa que las dos variables apuntan al mismo objeto, lo que permite comprobar el funcionamiento del patrón Singleton.

Esta prueba también permite verificar que los distintos niveles de registro generan mensajes con el mismo formato y utilizan el mismo archivo.


<img width="558" height="187" alt="image" src="https://github.com/user-attachments/assets/ed792ed9-c933-4374-9c36-46d4b54614d8" />
