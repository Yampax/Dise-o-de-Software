import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public abstract class CreadorTitulo {

    protected abstract String obtenerJurisdiccion();

    protected abstract TituloPropiedad crearTitulo(
            DatosSolicitud datos,
            ContextoJurisdiccion contexto,
            String firma);

    public final TituloPropiedad emitir(
            DatosSolicitud datos,
            ContextoJurisdiccion contexto) {

        if (datos == null || contexto == null) {
            throw new IllegalArgumentException(
                    "La solicitud y el contexto son obligatorios.");
        }

        if (!obtenerJurisdiccion().equalsIgnoreCase(
                contexto.getJurisdiccion())) {

            throw new IllegalArgumentException(
                    "La factoría no corresponde a la jurisdicción indicada.");
        }

        String firma = generarFirma(datos, contexto);

        return crearTitulo(datos, contexto, firma);
    }

    private String generarFirma(
            DatosSolicitud datos,
            ContextoJurisdiccion contexto) {

        try {
            String contenido =
                    datos.getDniPropietario()
                    + datos.getNombrePropietario()
                    + datos.getMatriculaInmueble()
                    + datos.getDomicilio()
                    + contexto.getJurisdiccion()
                    + contexto.getOrganismo()
                    + contexto.getCodigoNotarial();

            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            byte[] resultado = digest.digest(
                    contenido.getBytes(StandardCharsets.UTF_8));

            return HexFormat.of().formatHex(resultado);

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(
                    "No se pudo generar la huella de integridad.", e);
        }
    }
}
