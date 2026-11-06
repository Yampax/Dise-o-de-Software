Implemente el patrón Factory Method para poder crear diferentes tipos de documentos sin que el código principal dependa directamente de sus clases concretas.
Para ello, utilicé una interfaz llamada Documento, que permite establecer una operación común para todos los formatos. Luego, creé las clases DocumentoTextoPlano y DocumentoEnriquecido, que implementan dicha interfaz.
También incorporé una clase abstracta CreadorDocumento, encargada de declarar el método fábrica crearDocumento(). A partir de ella, desarrollé dos clases creadoras concretas que se encargan de instanciar el tipo de documento correspondiente.
De esta manera, pude separar la creación de los objetos de la lógica principal del programa. Además, el código cliente no necesita conocer cómo se construye cada documento, lo que facilita agregar nuevos formatos en el futuro sin tener que modificar la estructura existente.

<img width="382" height="90" alt="image" src="https://github.com/user-attachments/assets/0fc96e72-be75-4951-b81d-f0e50e8e64af" />
