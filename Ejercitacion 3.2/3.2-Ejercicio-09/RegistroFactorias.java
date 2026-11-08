import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

public class RegistroFactorias {

    private final Map<String, CreadorConector> factorias =
            new ConcurrentHashMap<>();

    public void registrar(String protocolo, CreadorConector creador) {

        if (protocolo == null || protocolo.isBlank() || creador == null) {
            throw new IllegalArgumentException("Registro de factoría inválido.");
        }

        factorias.put(protocolo.toUpperCase(), creador);
    }

    public CreadorConector obtener(String protocolo) {

        CreadorConector creador =
                factorias.get(protocolo.toUpperCase());

        if (creador == null) {
            throw new IllegalArgumentException(
                    "Protocolo no registrado: " + protocolo);
        }

        return creador;
    }
}
