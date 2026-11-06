Implemente el patrón Factory Method para desarrollar un sistema capaz de generar comprobantes fiscales para diferentes jurisdicciones sin que el código principal dependa directamente de las clases concretas.

Para ello, creé una interfaz llamada ComprobanteFiscal, que establece las operaciones comunes que deben cumplir todos los comprobantes. Luego, desarrollé las clases ComprobanteArgentina y ComprobanteEspana, que implementan dicha interfaz y representan los comprobantes específicos de cada país.

También incorporé una clase abstracta llamada CreadorComprobante, encargada de declarar el método fábrica crearComprobante() y coordinar el proceso de emisión. A partir de ella, desarrollé las clases CreadorArgentina y CreadorEspana, que se encargan de generar el XML y crear el comprobante correspondiente a cada jurisdicción.

Además, creé la clase SolicitudFiscal para reunir los datos necesarios para la emisión y ValidadorFiscal para comprobar que la información esté completa y sea coherente antes de generar el comprobante. Por último, incorporé RegistroFactorias, que permite seleccionar el creador adecuado según el país solicitado.

De esta manera, pude separar la creación de los comprobantes de la lógica principal del sistema, facilitando la incorporación de nuevas jurisdicciones sin tener que modificar toda la estructura existente. También incorporé una simulación de autorización fiscal y firma digital para representar el proceso de emisión.

<img width="1231" height="204" alt="image" src="https://github.com/user-attachments/assets/bdbc1475-2f25-4470-82e1-97bdc8a75653" />

