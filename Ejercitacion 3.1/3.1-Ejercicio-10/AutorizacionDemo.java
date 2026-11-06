import java.util.UUID;

public class AutorizacionDemo implements ServicioAutorizacion {

    @Override
    public String solicitarAutorizacion(
            SolicitudFiscal solicitud
    ) throws ExcepcionFiscal {

        return "AUT-DEMO-" + UUID.randomUUID();
    }
}
