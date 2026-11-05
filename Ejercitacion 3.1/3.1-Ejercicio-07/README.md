Decidí implementar el patrón Factory Method para poder generar diferentes componentes de interfaz gráfica sin acoplar el código principal a sus clases concretas.

Para ello, creé las interfaces "Boton" y "CampoTexto", que establecen los contratos de comportamiento y renderizado que deben cumplir todos los componentes. Luego, desarrollé las implementaciones concretas para los estilos oscuro de escritorio y minimalista móvil, incorporando sus propias características visuales e interacciones.

También incorporé una clase abstracta llamada "CreadorInterfaz", encargada de declarar los métodos fábrica para crear botones y campos de texto. A partir de ella, desarrollé los creadores concretos "CreadorOscuro" y "CreadorMinimalista", que se encargan de generar componentes pertenecientes a una misma familia visual.

Finalmente, utilicé una clase "FabricaInterfaz" para centralizar la selección del creador según el estilo solicitado. De esta manera, pude garantizar que los componentes de una misma interfaz mantengan una apariencia coherente, separando su creación de la lógica principal del programa y facilitando la incorporación de nuevos estilos visuales.
