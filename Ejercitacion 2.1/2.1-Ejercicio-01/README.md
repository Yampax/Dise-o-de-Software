La clase Configuración implementa el patrón Singleton mediante un atributo estático inicialmente en null, un constructor privado y el método getInstancia(), que crea la instancia únicamente cuando se solicita por primera vez. De esta manera, toda la aplicación comparte el mismo objeto de configuración.

El constructor inicializa una estructura Properties y carga los parámetros desde el archivo config.properties, ubicado en la carpeta resources. Los métodos obtener() y existe() permiten consultar valores mediante sus claves y verificar si una propiedad está definida, evitando tener que leer el archivo en cada consulta.

Por último, el método getInstancia() utiliza synchronized para evitar que varios hilos creen instancias simultáneamente. El main comprueba la lectura de las propiedades y verifica que dos referencias obtenidas mediante el método de acceso correspondan a la misma instancia.

<img width="438" height="174" alt="image" src="https://github.com/user-attachments/assets/000bfc55-26b3-403b-878e-9c7e4b648547" />
