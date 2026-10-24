import java.io.IOException;
import java.util.Properties;

public class Configuración {

    private static Configuración instancia = null;

    private final Properties propiedades;

    // Constructor privado
    private Configuración() {
        propiedades = new Properties();
        cargarConfiguracion();
    }

    // Obtiene la única instancia
    public static synchronized Configuración getInstancia() {
        if (instancia == null) {
            instancia = new Configuración();
        }
        return instancia;
    }

    // Carga las propiedades desde resources
    private void cargarConfiguracion() {
        try (var archivo = getClass().getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (archivo == null) {
                System.out.println("No se encontró config.properties.");
                return;
            }

            propiedades.load(archivo);
            System.out.println("Configuración cargada correctamente.");

        } catch (IOException e) {
            System.out.println("Error al cargar configuración: "
                    + e.getMessage());
        }
    }

    // Obtiene el valor de una propiedad
    public synchronized String obtener(String clave) {
        if (clave == null || clave.isBlank()) {
            return null;
        }

        return propiedades.getProperty(clave);
    }

    // Verifica si existe una propiedad
    public synchronized boolean existe(String clave) {
        return clave != null && propiedades.containsKey(clave);
    }

    public static void main(String[] args) {

        Configuración config1 =
                Configuración.getInstancia();

        System.out.println("Nombre de la aplicación: "
                + config1.obtener("aplicacion.nombre"));

        System.out.println("Puerto del servidor: "
                + config1.obtener("servidor.puerto"));

        System.out.println("Base de datos: "
                + config1.obtener("baseDatos"));

        System.out.println("¿Existe la propiedad servidor.puerto? "
                + config1.existe("servidor.puerto"));

        Configuración config2 =
                Configuración.getInstancia();

        System.out.println("¿Es la misma instancia? "
                + (config1 == config2));
    }
}
