En este ejercicio se implementó el patrón Observer para simular un sistema empresarial de gestión de riesgos y auditoría. El objetivo fue permitir que, ante una modificación del perfil de riesgo de una cuenta, diferentes módulos reciban la notificación sin depender directamente de la clase principal.

Se creó la interfaz `ObservadorRiesgo`, que define los métodos que deben implementar los módulos interesados en los cambios. La clase `GestorRiesgo` actúa como sujeto observable, administra los perfiles de riesgo, mantiene la lista de observadores y se encarga de notificar las modificaciones.

Para garantizar la seguridad ante entornos multihilo se utilizó `CopyOnWriteArrayList` para la lista de observadores y `ConcurrentHashMap` para administrar las cuentas. Además, el método de modificación de riesgo está sincronizado para que las modificaciones y notificaciones se ejecuten de manera secuencial y controlada.

También se implementó un mecanismo de aislamiento de errores mediante bloques try-catch, permitiendo que si un observador falla, los demás puedan continuar procesando la notificación sin interrumpir el sistema.

Por último, se creó la clase `RegistroAuditoria`, encargada de almacenar los resultados de cada notificación, indicando cuáles módulos procesaron correctamente el cambio y cuáles presentaron errores. Los registros y sus resultados son inmutables y se pueden consultar sin permitir modificaciones externas.

De esta manera, se consigue una arquitectura desacoplada, segura ante modificaciones concurrentes y con trazabilidad de los eventos críticos, cumpliendo los requisitos planteados.

<img width="481" height="514" alt="image" src="https://github.com/user-attachments/assets/8679174a-e2a5-4978-8063-fa57290d4368" />
<img width="1014" height="368" alt="image" src="https://github.com/user-attachments/assets/4ac66bc4-d794-4648-853f-239405ee36fb" />
