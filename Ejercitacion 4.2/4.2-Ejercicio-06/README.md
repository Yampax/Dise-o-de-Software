En este ejercicio, el patrón Observer se aplica en la clase "MercadoDivisas", que funciona como sujeto observable y se encarga de administrar las cotizaciones de las distintas monedas.

Se creó la interfaz "ObservadorCotizacion", que define el método "actualizar()" que deben implementar los paneles interesados en recibir cambios. También se implementó la interfaz "Sujeto", que establece los métodos para suscribir, desuscribir y notificar a los observadores.

La clase "Cotizacion" permite encapsular la información de cada actualización, incluyendo la moneda, el precio actual y la variación porcentual respecto de la cotización anterior.

Los observadores concretos son "PanelGrafico", "TablaConversion" y "AlertaLimite". Cada uno recibe el objeto de cotización actualizado y realiza una acción diferente: mostrar la tendencia, calcular equivalencias monetarias o detectar variaciones que superen un límite establecido.

Cuando se ejecuta "actualizarCotizacion()", el mercado obtiene el precio anterior, calcula la diferencia porcentual, actualiza el valor almacenado y genera un nuevo objeto "Cotizacion". Luego, mediante el método "notificar()", comunica la actualización a todos los observadores suscritos.

Para evitar problemas al modificar la lista de suscriptores durante las notificaciones, se utiliza "CopyOnWriteArrayList", que permite recorrer la colección de manera segura mientras se realizan altas o bajas de observadores.

De esta manera, la lógica del mercado no depende directamente de los paneles de visualización y permite agregar nuevos componentes interesados en las cotizaciones sin modificar la clase principal, manteniendo un sistema desacoplado y extensible.

<img width="335" height="521" alt="image" src="https://github.com/user-attachments/assets/d0e9d64d-979c-4a2a-84fb-e9fda5410b8d" />
<img width="311" height="498" alt="image" src="https://github.com/user-attachments/assets/3ff3ad82-d1ba-41a3-8f70-e97d88e00a83" />
<img width="484" height="533" alt="image" src="https://github.com/user-attachments/assets/ed25a688-c8e1-4564-9aaf-bc1b70782e9a" />
<img width="297" height="297" alt="image" src="https://github.com/user-attachments/assets/c3c0f36f-a175-4efb-bfc0-58ce21b01a6f" />



