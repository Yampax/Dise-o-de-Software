import java.util.UUID;

public class FirmaDemo implements ServicioFirmaDigital {

    @Override
    public String firmar(String contenido)
            throws ExcepcionFiscal {

        if (contenido == null || contenido.isBlank()) {
            throw new ExcepcionFiscal(
                "No se puede firmar un documento vacío."
            );
        }

        return "FIRMA-DEMO-" + UUID.randomUUID();
    }
}
