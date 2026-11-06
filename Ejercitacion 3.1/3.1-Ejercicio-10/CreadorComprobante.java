
import java.util.UUID;

public abstract class CreadorComprobante {

    // Factory Method
    protected abstract ComprobanteFiscal crearComprobante(
            String xml, String autorizacion, String firma);

    // Cada país define cómo construir su XML.
    protected abstract String construirXML(SolicitudFiscal solicitud);

    // Método que coordina todo el proceso.
    public final ComprobanteFiscal emitir(SolicitudFiscal solicitud) {

        // 1. Validar datos.
        ValidadorFiscal.validar(solicitud);

        // 2. Construir XML.
        String xml = construirXML(solicitud);

        // 3. Simular autorización fiscal.
        String autorizacion = "AUT-" + UUID.randomUUID();

        // 4. Simular firma digital.
        String firma = "FIRMA-" + UUID.randomUUID();

        // 5. Crear el comprobante concreto.
        return crearComprobante(xml, autorizacion, firma);
    }

    // Escapa caracteres especiales para XML.
    protected String escaparXML(String texto) {
        return texto.replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;")
                    .replace("\"", "&quot;")
                    .replace("'", "&apos;");
    }
}
