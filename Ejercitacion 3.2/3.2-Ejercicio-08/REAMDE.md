Refactorizar el sistema de importación utilizando el patrón Factory Method, con el objetivo de eliminar la creación directa de importadores y reducir el acoplamiento entre las clases.

Creé la interfaz `Importador`, que establece un contrato común para los diferentes formatos de lectura. Luego desarrollé las clases `ImportadorCSV`, `ImportadorXML` e `ImportadorJSON`, que representan las implementaciones concretas.

Implementé la clase abstracta `CreadorImportador`, que declara el método de fábrica `crearImportador()`. A partir de ella desarrollé los creadores concretos, encargados de instanciar cada tipo de importador.

También incorporé `SelectorFactorias`, que centraliza la selección del creador correspondiente mediante un mapa de formatos y creadores. De esta manera, la lógica de selección queda separada de la lógica de procesamiento.

Desarrollé `ProcesadorDatos` para recibir un creador mediante su constructor y utilizarlo para obtener el importador necesario. Así, esta clase trabaja únicamente con abstracciones y no necesita conocer las implementaciones concretas.

Finalmente, en `Main` selecciono el formato deseado y solicito el procesamiento del archivo.

Considero que esta solución mejora la organización del código, aplica inversión de control y permite incorporar nuevos formatos de importación sin modificar la lógica principal de procesamiento.

<img width="359" height="80" alt="image" src="https://github.com/user-attachments/assets/eadfaa2c-880b-4205-af28-8a1b6e3dce11" />
