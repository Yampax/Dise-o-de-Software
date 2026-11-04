Decidí implementar el patrón Factory Method para facilitar la creación de diferentes clases de personajes, cada uno con sus propias estadísticas y equipamiento inicial.

Para ello, creé una clase abstracta llamada "Personaje", que establece las características comunes de todos los personajes. Luego, desarrollé las clases "Guerrero", "Mago" y "Arquero", que definen sus propios atributos y armas iniciales.

También incorporé una clase abstracta "CreadorPersonaje", encargada de declarar el método fábrica "crearPersonaje()". A partir de ella, desarrollé creadores concretos para cada clase de personaje.

Finalmente, utilicé una clase "FabricaPersonajes" para centralizar la selección del creador correspondiente según el tipo solicitado.

De esta manera, pude separar la creación de los personajes de la lógica principal del programa, evitando utilizar múltiples condicionales y facilitando la incorporación de nuevas clases de personajes en el futuro.
