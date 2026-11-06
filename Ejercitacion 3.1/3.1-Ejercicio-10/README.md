Implemente el patrón Factory Method para desarrollar un sistema capaz de generar comprobantes fiscales electrónicos adaptados a las normativas de diferentes jurisdicciones, evitando que la lógica principal dependa de las clases concretas de cada país.

Para ello, creé una interfaz llamada `ComprobanteFiscal`, que establece un contrato común para los documentos generados. Luego, desarrollé las clases `ComprobanteArgentina` y `ComprobanteEspana`, que representan los comprobantes correspondientes a cada jurisdicción.

También incorporé una clase abstracta `CreadorComprobante`, encargada de declarar el método fábrica `crearComprobante()`. Esta clase organiza el proceso de emisión, realizando las validaciones tributarias antes de construir el documento, solicitar la autorización y generar la firma digital. A partir de ella, desarrollé factorías concretas que implementan las particularidades de cada país.

Además, incorporé servicios independientes para la autorización y la firma digital, junto con un registro concurrente de factorías que permite incorporar nuevas jurisdicciones sin modificar la lógica principal. Para proteger la integridad de la información, utilicé objetos inmutables, validaciones de datos y manejo de excepciones específicas.

De esta manera, pude separar las responsabilidades de validación, creación y seguridad, logrando una arquitectura más desacoplada, extensible y preparada para trabajar en entornos concurrentes.

<img width="1235" height="236" alt="image" src="https://github.com/user-attachments/assets/29013ed5-48ff-41fd-be3c-1b6bb373ca20" />
