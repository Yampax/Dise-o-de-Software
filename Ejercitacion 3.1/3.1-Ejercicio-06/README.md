Implemente el patrón Factory Method para poder procesar pagos mediante diferentes pasarelas sin acoplar el código principal a las clases concretas de cada medio de pago.

Para ello, creé una interfaz llamada "PasarelaPago", que establece un método común para procesar transacciones y devolver un comprobante. Luego, desarrollé las clases "PagoTarjeta", "PagoTransferencia" y "PagoMonedero", que implementan sus propias reglas de comisión.

También incorporé una clase abstracta "CreadorPasarela", encargada de declarar el método fábrica "crearPasarela()". A partir de ella, desarrollé creadores concretos que instancian la pasarela correspondiente y establecen el monto mínimo permitido para cada medio de pago.

Finalmente, utilicé una clase "FabricaPagos" para centralizar la selección del creador según el método indicado en la orden de compra. De esta manera, pude separar la creación de las pasarelas de la lógica principal del sistema, permitiendo incorporar nuevos medios de pago sin modificar la estructura existente.

<img width="352" height="482" alt="image" src="https://github.com/user-attachments/assets/ef68057b-c227-4080-a485-e616dbc515b6" />
