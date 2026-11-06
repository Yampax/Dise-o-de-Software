Implemente el patrón Factory Method para poder crear diferentes tipos de perfiles de usuario sin que el código principal dependa directamente de sus clases concretas. Para ello, creé una interfaz llamada `PerfilUsuario`, que establece dos operaciones comunes para consultar el rol y los permisos de cada usuario.

Luego, desarrollé las clases `Estudiante` y `Docente`, que implementan dicha interfaz y definen los permisos correspondientes a cada tipo de perfil. También incorporé una clase abstracta llamada `CreadorPerfil`, encargada de declarar el método fábrica `crearPerfil()`.

A partir de ella, desarrollé las clases creadoras concretas `CreadorEstudiante` y `CreadorDocente`, que se encargan de instanciar el perfil correspondiente a su especialidad. Finalmente, desde la clase principal utilicé estos creadores para obtener los perfiles sin crear directamente los objetos.

De esta manera, pude separar la lógica de creación de perfiles del código principal, facilitando la incorporación de nuevos tipos de usuarios en el futuro sin modificar la estructura existente.

<img width="667" height="190" alt="image" src="https://github.com/user-attachments/assets/0b2db637-8835-459c-bc1d-b9c39e5a4293" />
