En este ejercicio, el patrón Observer se aplica en la clase "MercadoDivisas", que funciona como sujeto observable y se encarga de administrar las cotizaciones de las distintas monedas.

Se creó la interfaz "ObservadorCotizacion", que define el método "actualizar()" que deben implementar los paneles interesados en recibir cambios. También se implementó la interfaz "Sujeto", que establece los métodos para suscribir, desuscribir y notificar a los observadores.

La clase "Cotizacion" permite encapsular la información de cada actualización, incluyendo la moneda, el precio actual y la variación porcentual respecto de la cotización anterior.

Los observadores concretos son "PanelGrafico", "TablaConversion" y "AlertaLimite". Cada uno recibe el objeto de cotización actualizado y realiza una acción diferente: mostrar la tendencia, calcular equivalencias monetarias o detectar variaciones que superen un límite establecido.

Cuando se ejecuta "actualizarCotizacion()", el mercado obtiene el precio anterior, calcula la diferencia porcentual, actualiza el valor almacenado y genera un nuevo objeto "Cotizacion". Luego, mediante el método "notificar()", comunica la actualización a todos los observadores suscritos.

Para evitar problemas al modificar la lista de suscriptores durante las notificaciones, se utiliza "CopyOnWriteArrayList", que permite recorrer la colección de manera segura mientras se realizan altas o bajas de observadores.

De esta manera, la lógica del mercado no depende directamente de los paneles de visualización y permite agregar nuevos componentes interesados en las cotizaciones sin modificar la clase principal, manteniendo un sistema desacoplado y extensible.
