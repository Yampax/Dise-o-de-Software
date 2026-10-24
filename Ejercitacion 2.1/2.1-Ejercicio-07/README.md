La clase CentralImpresion implementa el patrón Singleton mediante un atributo estático inicialmente en null, un constructor privado y el método getInstancia(), que crea la instancia únicamente cuando se solicita por primera vez. Así, todas las terminales utilizan la misma central de impresión y comparten una única cola de documentos.

La cola se encuentra encapsulada y almacena los documentos junto con su nombre de archivo y autor. El método encolarDocumento() agrega nuevos trabajos, mientras que imprimirSiguiente() procesa y elimina el documento más antiguo. El método imprimirTodos() permite procesar secuencialmente todos los trabajos pendientes.

Los métodos que manipulan la cola están sincronizados para evitar condiciones de carrera durante el acceso concurrente. El main prueba el agregado y procesamiento de documentos, así como la reutilización de la misma instancia.

<img width="401" height="290" alt="image" src="https://github.com/user-attachments/assets/d801f4cc-d349-4678-9030-2c31b9745fdd" />
