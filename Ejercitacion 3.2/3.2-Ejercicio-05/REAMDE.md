Para resolver este ejercicio implemente el patrón Factory Method, con el objetivo de crear diferentes tipos de enemigos sin que el programa principal tenga que conocer sus clases concretas.

Creé la interfaz Enemigo, que establece las características comunes de todos los enemigos, como salud, daño, velocidad y comportamiento táctico.

Desarrollé las clases SoldadoRaso y DroneCombate, donde definí los atributos y comportamientos iniciales específicos de cada tipo de enemigo.

Implementé la clase abstracta CreadorEnemigo, que declara el método de fábrica crearEnemigo(). Luego desarrollé los creadores concretos CreadorSoldado y CreadorDrone, encargados de instanciar cada enemigo.

También incorporé FabricaEnemigos, que permite seleccionar el creador correspondiente según el tipo solicitado. De esta manera, en Main solamente indico qué enemigo necesito, sin instanciar directamente los productos.

Considero que esta solución permite separar la creación de los enemigos de su utilización y facilita incorporar nuevos tipos con atributos y comportamientos diferentes.

<img width="343" height="265" alt="image" src="https://github.com/user-attachments/assets/b3f5989b-ec43-460c-b470-5dabdf0f7b75" />

