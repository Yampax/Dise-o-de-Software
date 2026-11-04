Decidí implementar el patrón Factory Method para poder generar reportes financieros en diferentes formatos sin acoplar el código principal a las clases encargadas de realizar cada exportación.

Para ello, creé una interfaz llamada "ExportadorReporte", que establece una operación común para exportar los informes. Luego, desarrollé las clases "ExportadorPDF" y "ExportadorCSV", que implementan la generación de archivos según las características de cada formato.

También incorporé una clase abstracta "CreadorExportador", encargada de declarar el método fábrica "crearExportador()". Además, agregué un método "generarReporte()" que organiza el proceso de validación de los datos, creación del exportador y generación del archivo.

Finalmente, desarrollé las clases creadoras concretas "CreadorPDF" y "CreadorCSV", que se encargan de proporcionar el exportador correspondiente.

De esta manera, pude separar la creación de los exportadores de la lógica principal del sistema, facilitando la incorporación de nuevos formatos y el mantenimiento del código.
