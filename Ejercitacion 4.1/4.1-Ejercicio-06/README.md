En este ejercicio se desarrolla un sistema de cotizaciones bursátiles que permite actualizar el precio de un activo financiero y comunicar automáticamente los cambios a diferentes paneles de visualización.

El patrón Observer se aplica mediante la relación entre la clase MercadoBursatil y los paneles que reciben las actualizaciones. La interfaz Observador establece el método actualizar(), que deben implementar los distintos paneles. Por otro lado, la interfaz Sujeto define los métodos necesarios para suscribir, desuscribir y notificar a los observadores.

La clase MercadoBursatil es la encargada de mantener la cotización actual y administrar la lista de suscriptores. Cuando se ejecuta el método actualizarPrecio(), se obtiene el precio anterior y se calcula la variación porcentual respecto del nuevo valor. Luego se crea un nuevo objeto Cotizacion con el nombre del activo, el precio actualizado y su variación.

Una vez actualizada la información, el mercado ejecuta el método notificar(), que recorre la lista de observadores y les envía el objeto de cotización. Las clases PanelGrafico, PanelResumen y AlertaVolatilidad implementan la interfaz Observador, pero cada una utiliza los datos recibidos para realizar una tarea diferente. El gráfico actualiza la representación de los precios, el panel de resumen muestra la cotización y su variación, y el sistema de alertas detecta cambios porcentuales importantes.

Además, la lista de suscriptores se administra mediante CopyOnWriteArrayList, lo que permite recorrerla de forma segura ante modificaciones concurrentes, incluso cuando se agregan o eliminan observadores durante el envío de notificaciones.

<img width="285" height="519" alt="image" src="https://github.com/user-attachments/assets/b8ff5796-a28d-4925-ac17-4f030e71f7ef" />

<img width="319" height="502" alt="image" src="https://github.com/user-attachments/assets/88653d2c-321f-4110-a58a-97c1a9b1566a" />

