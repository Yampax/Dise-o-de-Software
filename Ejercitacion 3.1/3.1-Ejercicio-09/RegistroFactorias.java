import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RegistroFactorias {

    private ConcurrentMap<String, CreadorConector> factorias;

    public RegistroFactorias() {

        factorias = new ConcurrentHashMap<>();
    }

    public void registrar(
            String protocolo,
            CreadorConector creador) {

        if (protocolo == null || protocolo.isBlank()
                || creador == null) {

            throw new IllegalArgumentException(
                "El protocolo y la factoría son obligatorios."
            );
        }

        factorias.put(protocolo.toUpperCase(), creador);
    }

    public ConectorIoT crear(
            String protocolo,
            ConfiguracionIoT configuracion
    ) throws ExcepcionConexion {

        CreadorConector creador =
            factorias.get(protocolo.toUpperCase());

        if (creador == null) {
            throw new ExcepcionConexion(
                "No existe una factoría registrada para "
                + protocolo
            );
        }

        return creador.inicializar(configuracion);
    }
}
