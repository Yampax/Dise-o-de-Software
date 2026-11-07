Implemente el patrón Factory Method para poder generar comprobantes comerciales en diferentes formatos sin que el código principal dependa directamente de las clases encargadas de realizar cada generación. Para ello, creé una interfaz llamada `GeneradorComprobante`, que establece una operación común para generar los documentos.

Luego, desarrollé las clases `GeneradorPDF` y `GeneradorTicket`, que implementan dicha interfaz y contienen la lógica necesaria para generar cada formato. Además, incorporé validaciones de los datos monetarios en cada generador para comprobar que los importes sean válidos antes de emitir los comprobantes.

También creé una clase abstracta llamada `CreadorComprobante`, encargada de declarar el método fábrica `crearGenerador()` y coordinar el proceso de generación. A partir de ella, desarrollé las clases creadoras concretas `CreadorPDF` y `CreadorTicket`, que se encargan de proporcionar el generador correspondiente.

Finalmente, utilicé la clase `Main` para solicitar la generación de ambos comprobantes mediante sus creadores, sin instanciar directamente los generadores concretos.

De esta manera, pude separar la creación de los generadores de la lógica de formato de los documentos, facilitando la incorporación de nuevos formatos de comprobantes y el mantenimiento del sistema.

<img width="778" height="192" alt="image" src="https://github.com/user-attachments/assets/125e8433-879e-4141-9321-74b532e8a2cb" />
