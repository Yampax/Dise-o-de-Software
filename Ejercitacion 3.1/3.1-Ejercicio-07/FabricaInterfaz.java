import java.util.HashMap;
import java.util.Map;

public class FabricaInterfaz {

    private Map<String, CreadorInterfaz> creadores;

    public FabricaInterfaz() {

        creadores = new HashMap<>();

        creadores.put("oscuro", new CreadorOscuro());
        creadores.put("minimalista", new CreadorMinimalista());
    }

    public CreadorInterfaz obtenerCreador(String estilo) {

        CreadorInterfaz creador =
            creadores.get(estilo.toLowerCase());

        if (creador == null) {
            throw new IllegalArgumentException(
                "El estilo de interfaz seleccionado no existe."
            );
        }

        return creador;
    }
}
