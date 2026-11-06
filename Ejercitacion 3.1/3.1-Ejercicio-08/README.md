Refactorizar el sistema utilizando el patrón Factory Method para eliminar los bloques condicionales que se encargaban de instanciar directamente los diferentes compresores.

Para ello, creé una interfaz llamada `Compresor`, que establece un método común para realizar la compresión de archivos. Luego, desarrollé las clases `CompresorZIP`, `CompresorTAR` y `CompresorGZ`, que implementan dicho comportamiento para cada formato.

También incorporé una clase abstracta llamada `CreadorCompresor`, encargada de declarar el método fábrica `crearCompresor()`. A partir de ella, desarrollé creadores concretos que se encargan de instanciar el compresor correspondiente.

Finalmente, utilicé una clase `FabricaCompresores` para centralizar la selección del creador y modifiqué `SistemaArchivos` para que reciba una abstracción mediante su constructor, sin depender de las clases concretas. De esta manera, pude separar la selección, creación y utilización de los compresores, facilitando el mantenimiento del código y la incorporación de nuevos formatos sin modificar la lógica principal del sistema.

<img width="380" height="96" alt="image" src="https://github.com/user-attachments/assets/1ba7619d-6970-4331-ad01-fafba511481b" />
