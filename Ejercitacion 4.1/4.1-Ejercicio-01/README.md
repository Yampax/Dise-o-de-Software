En este ejercicio desarrollé un sistema de notificación de cambios de temperatura en el que una estación meteorológica puede comunicar automáticamente las actualizaciones a diferentes pantallas.

Para organizar el código, utilicé una interfaz llamada Observador, que establece el método actualizar() que deben implementar todos los dispositivos interesados en recibir la temperatura. También definí la interfaz Sujeto, que establece las operaciones necesarias para registrar, eliminar y notificar a los observadores.

La clase EstacionMeteorologica es la encargada de almacenar la temperatura y mantener una lista genérica de observadores mediante List<Observador>. Cuando se registra un dispositivo, se agrega a esa lista, y cuando se lo elimina, deja de recibir notificaciones.

La aplicación del patrón Observer se puede observar principalmente en el método notificar(), donde se recorre la lista de observadores y se ejecuta actualizar() para comunicarles la temperatura actual. Esto también ocurre automáticamente desde setTemperatura(), cada vez que se modifica el valor de la temperatura.

Por último, la clase Pantalla implementa la interfaz Observador y define cómo recibe y muestra la información. Gracias a esta estructura, es posible incorporar nuevos dispositivos sin modificar la estación meteorológica, ya que todos trabajan mediante una interfaz común.

<img width="390" height="208" alt="image" src="https://github.com/user-attachments/assets/df5072b1-9044-4e8d-82ee-55d1166f9347" />
