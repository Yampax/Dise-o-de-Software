Decidí implementar el patrón Factory Method para poder trabajar con diferentes motores de bases de datos sin acoplar la lógica principal del programa a una implementación específica.

Para ello, creé una interfaz llamada "ConexionBD", que establece una operación común para ejecutar consultas de prueba. Luego, desarrollé las clases "ConexionSQLite" y "ConexionPostgreSQL", que implementan dicha interfaz.

También incorporé una clase abstracta "CreadorConexion", encargada de declarar el método fábrica "crearConexion()". A partir de ella, desarrollé dos clases creadoras concretas que se encargan de instanciar la conexión correspondiente a cada motor.

De esta manera, pude separar la creación de las conexiones de la lógica que las utiliza. Esto facilita incorporar nuevos motores de bases de datos en el futuro sin tener que modificar la estructura principal del sistema.
