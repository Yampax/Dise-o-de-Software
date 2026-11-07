Iimplemente el patrón Factory Method para poder trabajar con diferentes tipos de almacenamiento sin que la lógica principal del programa dependa directamente de sus implementaciones concretas. Para ello, creé una interfaz llamada `Almacenamiento`, que establece dos operaciones comunes para guardar y recuperar archivos.

Luego, desarrollé las clases `AlmacenamientoLocal` y `AlmacenamientoNube`, que implementan dicha interfaz y definen el comportamiento correspondiente a cada tipo de almacenamiento. También incorporé una clase abstracta llamada `CreadorAlmacenamiento`, encargada de declarar el método fábrica `crearAlmacenamiento()` y proporcionar una operación para gestionar los archivos.

A partir de ella, desarrollé las clases creadoras concretas `CreadorLocal` y `CreadorNube`, que se encargan de instanciar el conector correspondiente a cada alternativa. Finalmente, utilicé la clase principal para seleccionar el creador según la preferencia del usuario y delegar las operaciones de almacenamiento.

De esta manera, pude separar la selección y creación de los servicios de almacenamiento de la lógica que gestiona los archivos, facilitando la incorporación de nuevas alternativas de almacenamiento en el futuro.

<img width="603" height="81" alt="image" src="https://github.com/user-attachments/assets/394c9806-2cd8-4762-ad0f-40db438ab6f8" />

