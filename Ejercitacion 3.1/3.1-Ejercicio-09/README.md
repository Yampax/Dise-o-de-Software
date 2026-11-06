Implemente el patrón Factory Method para desarrollar un sistema capaz de crear diferentes conectores IoT sin acoplar la aplicación a los protocolos de comunicación específicos.

Para ello, creé una interfaz llamada ConectorIoT, que establece las operaciones comunes de conexión, desconexión y reconexión. Luego, desarrollé los conectores concretos para MQTT, HTTP y CoAP, cada uno encargado de implementar la inicialización de su propio canal de comunicación.

También incorporé una clase abstracta CreadorConector, encargada de declarar el método fábrica crearConector() y realizar las validaciones de configuración y seguridad antes de crear cada conector. A partir de ella, desarrollé factorías concretas que construyen e inicializan el protocolo correspondiente, controlando posibles errores durante el proceso.

Además, incorporé una clase ConectorBase para centralizar la administración del estado de las conexiones y una clase MetricasConexion para registrar las operaciones realizadas. Para permitir la incorporación de nuevos protocolos en tiempo de ejecución, desarrollé RegistroFactorias, que utiliza un registro concurrente para almacenar y seleccionar las factorías disponibles.

De esta manera, pude separar la creación de los conectores, la gestión de las conexiones y el registro de las factorías, facilitando el mantenimiento y la ampliación del sistema sin modificar la lógica principal de la aplicación.

<img width="433" height="327" alt="image" src="https://github.com/user-attachments/assets/d85d2272-c6d4-4d72-bb22-ddb269c8eac5" />
