Se utiliza el patrón Singleton para garantizar que recepción y autoservicio compartan una única instancia del administrador de turnos. El método getInstancia() está sincronizado para evitar la creación de instancias duplicadas ante solicitudes simultáneas. Además, los métodos que trabajan con la agenda y los turnos utilizan synchronized para proteger el estado compartido. En particular, la verificación de disponibilidad y la asignación se realizan dentro de una misma operación atómica, evitando que dos pacientes obtengan el mismo horario. También se permite cancelar turnos y liberar los horarios correspondientes, sin modificar la agenda cuando la reserva no existe.

<img width="503" height="470" alt="image" src="https://github.com/user-attachments/assets/05126b05-0bcf-489d-aba2-8ab8ce995b6f" />

<img width="696" height="257" alt="image" src="https://github.com/user-attachments/assets/a409fea8-52f1-4355-823e-e567dc29480b" />
