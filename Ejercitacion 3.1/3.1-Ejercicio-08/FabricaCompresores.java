import java.util.HashMap;
import java.util.Map;

public class FabricaCompresores {

    private Map<String, CreadorCompresor> creadores;

    public FabricaCompresores() {

        creadores = new HashMap<>();

        creadores.put("ZIP", new CreadorZIP());
        creadores.put("TAR", new CreadorTAR());
        creadores.put("GZ", new CreadorGZ());
    }

    public CreadorCompresor obtenerCreador(String formato) {

        CreadorCompresor creador =
            creadores.get(formato.toUpperCase());

        if (creador == null) {
            throw new IllegalArgumentException(
                "Formato de compresión no compatible."
            );
        }

        return creador;
    }
}
