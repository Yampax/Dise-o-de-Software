## Justificación de las importaciones

En primer lugar, incorporé las siguientes importaciones:

import java.util.HashMap;

import java.util.Map;

La importación java.util.Map permite trabajar con una estructura que almacena información mediante pares de clave y valor. En este caso, las claves son cadenas de texto (String) y los valores son objetos de tipo Object, lo que permite guardar diferentes tipos de datos.

Por otro lado, java.util.HashMap proporciona una implementación de la interfaz Map que permite almacenar, recuperar, actualizar y eliminar elementos mediante sus claves.

Decidí utilizar esta estructura porque resulta adecuada para una caché en la que cada elemento debe identificarse mediante una clave única. Por ejemplo, podría utilizarse la clave usuario1 para almacenar y recuperar el perfil correspondiente a un usuario.

## Implementación del patrón Singleton

Para garantizar que toda la aplicación utilice una única instancia de la caché, implementé el patrón Singleton mediante un constructor privado, una clase interna estática y un método de acceso público.

El constructor se declara como private para impedir que otras clases creen instancias de CacheMemoria utilizando directamente el operador new.

De esta manera, evito que diferentes componentes de la aplicación creen sus propias cachés independientes, lo que podría provocar la duplicación de información y dificultar su administración.

El mensaje de consola permite identificar cuándo se inicializa la caché por primera vez.

Clase interna para la inicialización diferida:

Utilicé una clase interna estática llamada InstanciaHolder para implementar la inicialización diferida, también conocida como Lazy Initialization.

La instancia de CacheMemoria se crea cuando se accede por primera vez al campo INSTANCIA de esta clase interna. Por lo tanto, no se crea simplemente al cargar la clase externa, sino cuando realmente se solicita la caché.

El modificador static permite que la clase interna exista sin necesidad de crear previamente un objeto de la clase externa, mientras que final impide reemplazar la referencia a la instancia creada.

Además, este mecanismo aprovecha la inicialización segura de las clases en Java, por lo que no necesita sincronizar manualmente el método que obtiene la instancia.

Método de acceso a la instancia getInstancia():

Este método proporciona un punto de acceso común a la caché. Al ser público y estático, puede invocarse desde cualquier clase sin crear previamente un objeto de CacheMemoria.

Cuando se llama a getInstancia(), Java inicializa la clase interna InstanciaHolder si todavía no lo hizo y devuelve la instancia existente en las llamadas posteriores.

De esta manera, todos los componentes que utilizan este método acceden al mismo repositorio de datos.

## Encapsulamiento de la estructura de datos

Para almacenar los elementos de la caché, declaré el siguiente atributo:

private final Map<String, Object> cache = new HashMap<>();

Este atributo representa la estructura interna donde se guardan los datos. Cada elemento se identifica mediante una clave de tipo String y se asocia con un valor de tipo Object.

El modificador private impide que otras clases accedan directamente al mapa y modifiquen su contenido sin utilizar los métodos definidos por el Singleton. De esta forma, las operaciones de almacenamiento y eliminación quedan centralizadas.

Por su parte, final impide que la referencia del atributo se reasigne a otro mapa, aunque permite modificar el contenido del mapa existente mediante los métodos correspondientes.

Consideré importante mantener esta estructura encapsulada porque el objetivo del ejercicio es que la caché tenga un único punto de administración y que sus datos no puedan modificarse directamente desde el exterior.

## Almacenamiento de elementos

Para guardar información, implementé el método guardar():

Este método recibe una clave y un valor. Antes de almacenarlos, realiza una validación para comprobar que la clave no sea nula ni esté vacía y que el valor tampoco sea nulo.

Si alguno de estos datos no es válido, se muestra un mensaje y la operación finaliza mediante return, evitando guardar información incorrecta.

Cuando los datos son válidos, se utiliza cache.put(clave, valor) para almacenar el elemento. Si la clave ya existe, su valor anterior se reemplaza por el nuevo. Esto permite actualizar un dato existente sin necesidad de eliminarlo previamente.

El modificador synchronized permite coordinar el acceso al método entre diferentes hilos que utilicen la misma instancia, evitando que varias operaciones de escritura se ejecuten simultáneamente sobre el mapa.

## Recuperación de elementos

Para recuperar un elemento almacenado, desarrollé el método obtener():

Este método recibe la clave del elemento que se desea recuperar. Antes de devolver el valor, utiliza el método existe() para comprobar si la clave está presente en la caché.

Si la clave no existe, muestra un mensaje informativo y devuelve null. Si existe, devuelve el valor asociado mediante cache.get(clave).

Esta validación permite evitar que el sistema intente recuperar información que no se encuentra almacenada. El uso de null indica que no se obtuvo un valor, aunque en una aplicación real podría complementarse con un mecanismo más explícito para diferenciar entre una clave inexistente y otros resultados.

## Validación de claves

Para comprobar si un elemento se encuentra almacenado, implementé el método existe():

Este método devuelve un valor booleano: true cuando la clave existe y false cuando no existe o es nula.

La condición clave != null evita realizar una comprobación sobre una referencia nula. Por su parte, cache.containsKey(clave) verifica si el mapa contiene esa clave.

Decidí separar esta validación en un método propio porque puede reutilizarse en otras operaciones, como la recuperación, la actualización y la eliminación de elementos. Esto reduce la repetición de código y facilita el mantenimiento.

## Actualización de datos

Para modificar un elemento existente, desarrollé el método actualizar():

Este método recibe la clave del elemento y su nuevo valor. Antes de realizar la modificación, verifica que la clave exista y que el nuevo valor no sea nulo.

Si alguna de estas condiciones no se cumple, devuelve false para indicar que la actualización no pudo realizarse. En cambio, si los datos son válidos, utiliza cache.put() para reemplazar el valor asociado a la clave y devuelve true.

La diferencia principal respecto de guardar() es que este método no permite crear una entrada nueva: únicamente modifica elementos que ya existen. Así, se cumple el requisito de incorporar un mecanismo específico para actualizar datos almacenados.

## Eliminación de elementos

Para eliminar información de la caché, implementé el método eliminar():

Este método verifica primero que la clave exista. Si no se encuentra, muestra un mensaje y devuelve false.

Si el elemento está almacenado, utiliza cache.remove(clave) para eliminar la entrada correspondiente y devuelve true.

La operación permite administrar el contenido de la caché cuando un dato deja de ser necesario o debe retirarse. Esto resulta importante porque el ejercicio plantea una disponibilidad de memoria limitada.

Sin embargo, este método elimina elementos únicamente cuando se solicita expresamente. Para administrar automáticamente un límite de memoria sería necesario incorporar una política adicional de expulsión de datos.

## Consulta de la cantidad de elementos

También incorporé el método cantidadElementos():

Este método devuelve la cantidad de entradas almacenadas en la caché mediante cache.size().

Lo incluí para facilitar el control y la comprobación del contenido del repositorio durante las pruebas. De esta manera, es posible verificar cuántos elementos permanecen almacenados después de realizar operaciones de guardado y eliminación.

Al igual que los demás métodos que acceden a la estructura interna, se encuentra sincronizado.

## Sincronización de las operaciones

Uno de los requisitos del ejercicio es que la caché compartida esté sincronizada. Para cumplirlo, utilicé el modificador synchronized en los métodos públicos que consultan o modifican su contenido.

Este mecanismo hace que un hilo deba adquirir el monitor del objeto antes de ejecutar uno de estos métodos. Mientras un hilo mantiene ese monitor, otro hilo que intente entrar en un método sincronizado sobre la misma instancia debe esperar.

Esto ayuda a evitar que varias operaciones interfieran entre sí al acceder al mapa compartido.

Además, el método obtener() llama a existe() y el método actualizar() también realiza esa comprobación. Como ambos métodos sincronizados pertenecen al mismo objeto, Java permite que un hilo vuelva a adquirir el monitor que ya posee.

Es importante aclarar que esta sincronización protege las operaciones realizadas a través de los métodos de esta clase dentro de una misma ejecución de Java. No establece, por sí sola, un límite de memoria ni coordina distintas aplicaciones o procesos independientes.

## Prueba de funcionamiento

Para comprobar el comportamiento de la caché, utilicé el método main():

En primer lugar, obtengo la instancia única mediante getInstancia(). Después, almaceno dos elementos con claves diferentes y recupero el valor asociado a usuario1.

A continuación, actualizo ese elemento y vuelvo a consultarlo para comprobar que el nuevo valor reemplazó al anterior. Luego verifico la existencia de usuario2 y elimino ese elemento.

Finalmente, solicito nuevamente la instancia y comparo las referencias cache1 y cache2 mediante el operador ==. Si el resultado es true, ambas variables apuntan al mismo objeto.

La última consulta permite comprobar cuántos elementos quedan almacenados después de las operaciones realizadas.

Esta prueba verifica las funciones principales del ejercicio, aunque no constituye por sí sola una prueba de concurrencia entre múltiples hilos.

<img width="349" height="256" alt="image" src="https://github.com/user-attachments/assets/08a44edf-e336-4994-bd53-29588f5a7301" />
