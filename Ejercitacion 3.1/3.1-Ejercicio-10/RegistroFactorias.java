import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RegistroFactorias {

    private final ConcurrentMap<String, CreadorComprobante> factorias =
        new ConcurrentHashMap<>();

    public void registrar(String pais,
                          CreadorComprobante creador) {

        if (pais == null || pais.isBlank() || creador == null) {
            throw new IllegalArgumentException(
                "El país y la factoría son obligatorios."
            );
        }

        String clave = pais.toUpperCase();

        CreadorComprobante existente =
            factorias.putIfAbsent(clave, creador);

        if (existente != null) {
            throw new IllegalArgumentException(
                "Ya existe una factoría registrada para " + clave
            );
        }
    }

    public ComprobanteFiscal emitir(
            SolicitudFiscal solicitud
    ) throws ExcepcionFiscal {

        if (solicitud == null
                || solicitud.getPais() == null
                || solicitud.getPais().isBlank()) {

            throw new ExcepcionFiscal(
                "No se puede identificar la jurisdicción."
            );
        }

        String pais = solicitud.getPais().toUpperCase();

        CreadorComprobante creador = factorias.get(pais);

        if (creador == null) {
            throw new ExcepcionFiscal(
                "No existe una factoría registrada para " + pais
            );
        }

        return creador.emitir(solicitud);
    }
}
