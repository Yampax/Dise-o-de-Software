import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Evento {

    private final String tipo;
    private final Map<String, Object> payload;

    public Evento(String tipo, Map<String, Object> payload) {
        if (tipo == null || tipo.isBlank()) {
            throw new IllegalArgumentException(
                    "El tipo de evento no puede estar vacío");
        }

        this.tipo = tipo;
        this.payload = Collections.unmodifiableMap(
                new HashMap<>(payload)
        );
    }

    public String getTipo() {
        return tipo;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }
}
