import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuración {

    private static final Configuración instancia = new Configuración();

    private final Properties propiedades = new Properties();

    private Configuración(){
        try (InputStream entrada =
                     Configuración.class.getResourceAsStream("/config.properties")) {

            if (entrada == null) {
                throw new RuntimeException(
                        "No se encontró config.properties en la carpeta de recursos."
                );
            }

            propiedades.load(entrada);

        } catch (IOException e) {
            throw new RuntimeException(
                    "No se pudo cargar la configuración", e
            );
        }
    }

    public static Configuración getInstance(){
        return instancia;
    }

    public String getPropiedad(String clave) {
        return propiedades.getProperty(clave);
    }


}
