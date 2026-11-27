En este ejercicio se refactorizó un sistema de inventario para reducir el acoplamiento entre sus clases. Antes, la lógica de modificación del stock dependía directamente de los módulos de facturación y estadísticas, por lo que cualquier cambio en estos módulos podía afectar al funcionamiento del inventario.

Para solucionar este problema se implementó el patrón Observer. Se creó la interfaz `ObservadorStock`, que define el método `actualizarStock()`, y la interfaz `Sujeto`, que establece los métodos para suscribir, desuscribir y notificar a los observadores.

La clase `Inventario` implementa la interfaz Sujeto y se encarga de administrar el stock y mantener una lista de observadores. Cuando se modifica la cantidad de un producto, notifica automáticamente a los módulos que se encuentran suscriptos.

Por otro lado, `ModuloFacturacion` y `ModuloEstadisticas` implementan la interfaz `ObservadorStock`, por lo que reciben las actualizaciones sin que el inventario tenga que conocer sus implementaciones.

De esta manera, se consigue una mayor separación de responsabilidades y se facilita la incorporación de nuevos módulos sin modificar la clase principal de inventario. Además, los observadores pueden suscribirse o desuscribirse según sea necesario.

<img width="523" height="489" alt="image" src="https://github.com/user-attachments/assets/e9bda329-a8fe-4656-a722-b06b2ea96ab8" />
