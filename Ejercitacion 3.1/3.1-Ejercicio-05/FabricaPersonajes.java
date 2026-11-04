import java.util.HashMap;
import java.util.Map;

public class FabricaPersonajes {

    private final Map<String, CreadorPersonaje> creadores;

    public FabricaPersonajes() {

        creadores = new HashMap<>();

        creadores.put("guerrero", new CreadorGuerrero());
        creadores.put("mago", new CreadorMago());
        creadores.put("arquero", new CreadorArquero());
    }

    public Personaje crearPersonaje(String tipo, String nombre) {

        CreadorPersonaje creador = creadores.get(
            tipo.toLowerCase()
        );

        if (creador == null) {
            throw new IllegalArgumentException(
                "Tipo de personaje no válido."
            );
        }

        return creador.crearPersonaje(nombre);
    }
}
