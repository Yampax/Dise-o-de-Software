Implemente el patrón Factory Method para controlar la creación de títulos de propiedad según la jurisdicción correspondiente. Definí una clase abstracta de título y diferentes implementaciones concretas para representar los formatos registrales de cada provincia.

También desarrollé una clase creadora abstracta que valida los datos de la solicitud y el contexto legal antes de permitir la creación del documento. De esta manera, evito que se emitan títulos cuando faltan datos obligatorios o cuando se utiliza una factoría que no corresponde a la jurisdicción indicada.

Para mejorar la seguridad, utilicé atributos inmutables, validaciones de entrada y generación de huellas de integridad mediante SHA-256. Además, evité compartir objetos mutables durante la creación de documentos para permitir que el sistema trabaje en entornos multihilo.

Con esta implementación logré separar la creación de los títulos de las reglas particulares de cada jurisdicción, facilitando la incorporación de nuevas jurisdicciones sin modificar la lógica principal del sistema.

<img width="644" height="337" alt="image" src="https://github.com/user-attachments/assets/d22dbc4f-046e-4555-9eed-44248af7c155" />
