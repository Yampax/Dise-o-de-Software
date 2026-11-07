Implemente el patrón Factory Method para poder enviar alertas mediante diferentes canales de salida sin que el código principal dependa directamente de sus clases concretas. Para ello, creé una interfaz llamada "CanalAlerta", que establece un método común para enviar mensajes.

Luego, desarrollé las clases "AlertaConsola" y "AlertaArchivo", que implementan dicha interfaz y definen cómo se muestran o almacenan las alertas según el canal utilizado. También incorporé una clase abstracta llamada "CreadorAlerta", encargada de declarar el método fábrica "crearAlerta()" y proporcionar una operación para enviar mensajes.

A partir de ella, desarrollé las clases creadoras concretas "CreadorConsola" y "CreadorArchivo", que se encargan de instanciar el canal de salida correspondiente. Finalmente, desde la clase principal utilicé estos creadores para enviar las alertas sin crear directamente los objetos concretos.

De esta manera, pude separar la creación de los canales de salida de la lógica que utiliza las alertas, facilitando la incorporación de nuevos medios de notificación en el futuro.

<img width="612" height="92" alt="image" src="https://github.com/user-attachments/assets/b158344b-792f-436d-bcb9-2e92f7db72d6" />
