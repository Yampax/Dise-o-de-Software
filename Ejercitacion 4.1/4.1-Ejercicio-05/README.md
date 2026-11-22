En este ejercicio se desarrolla un sistema de seguridad para un edificio inteligente, donde diferentes sensores pueden detectar la presencia de humo y enviar alertas a los sistemas encargados de responder ante una emergencia.

El patrón Observer se aplica mediante la relación entre los sensores y los dispositivos de respuesta. La interfaz Observador establece el método actualizar(), que deben implementar todos los sistemas que necesitan recibir las alertas. Por otro lado, la interfaz Sujeto define los métodos para registrar, eliminar y notificar a los observadores.

La clase SensorHumo representa cada sensor instalado en una ubicación específica del edificio. Esta clase mantiene una lista de observadores suscritos y, cuando se ejecuta el método detectarHumo(), genera una notificación que incluye la ubicación exacta y el mensaje de emergencia. Luego, mediante notificar(), envía esa información a todos los dispositivos registrados.

Las clases CentralAlarmas, SistemaRociadores y ServicioConserjeria implementan la interfaz Observador. Cada una recibe la misma alerta, pero realiza una acción diferente: la central activa la alarma, el sistema de rociadores activa el mecanismo correspondiente y conserjería recibe el aviso de emergencia.

Además, el sistema permite que un mismo dispositivo esté suscrito a varios sensores, por lo que puede recibir alertas de diferentes ubicaciones. También es posible agregar o eliminar observadores durante la ejecución sin modificar el funcionamiento interno de los sensores.

<img width="526" height="493" alt="image" src="https://github.com/user-attachments/assets/a0e527a1-9d28-4e0a-bb2e-4e8dc732b24b" />

<img width="500" height="385" alt="image" src="https://github.com/user-attachments/assets/f3d0ca78-a47a-49f0-88bd-111963f91481" />
