
import java.util.HashMap;
import java.util.Map;

public class RegistroFactorias {

    private final Map<String, CreadorComprobante> factorias =
            new HashMap<>();

    public void registrar(String pais, CreadorComprobante creador) {

        if (pais == null || pais.isBlank() || creador == null) {
            throw new IllegalArgumentException("Datos de registro inválidos.");
        }

        String clave = pais.toUpperCase();

        if (factorias.containsKey(clave)) {
            throw new IllegalArgumentException("Ya existe una factoría para ese país.");
        }

        factorias.put(clave, creador);
    }

    public ComprobanteFiscal emitir(SolicitudFiscal solicitud) {

        if (solicitud == null || solicitud.getPais() == null) {
            throw new IllegalArgumentException("Solicitud inválida.");
        }

        String pais = solicitud.getPais().toUpperCase();

        CreadorComprobante creador = factorias.get(pais);

        if (creador == null && pais.equals("ESPAÑA")) {
            creador = factorias.get("ESPANA");
        }

        if (creador == null) {
            throw new IllegalArgumentException("No existe una factoría para ese país.");
        }

        return creador.emitir(solicitud);
    }
}
