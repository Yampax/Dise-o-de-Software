public class Main {

    public static void main(String[] args) {

        // Registrar las factorías.
        RegistroFactorias registro = new RegistroFactorias();

        registro.registrar("ARGENTINA", new CreadorArgentina());
        registro.registrar("ESPAÑA", new CreadorEspana());

        // Solicitud para Argentina.
        SolicitudFiscal solicitudArgentina = new SolicitudFiscal(
                "Argentina",
                "Empresa Argentina S.A.",
                "30712345678",
                "Mendoza, Argentina",
                "Cliente Argentino",
                "20123456789",
                100000,
                21000,
                121000,
                "ARS"
        );

        // Solicitud para España.
        SolicitudFiscal solicitudEspana = new SolicitudFiscal(
                "España",
                "Empresa Española S.L.",
                "B12345678",
                "Madrid, España",
                "Cliente Español",
                "12345678Z",
                1000,
                210,
                1210,
                "EUR"
        );

        try {

            // Emitir comprobante argentino.
            ComprobanteFiscal comprobanteArgentina =
                    registro.emitir(solicitudArgentina);

            comprobanteArgentina.mostrarComprobante();

            System.out.println();

            // Emitir comprobante español.
            ComprobanteFiscal comprobanteEspana =
                    registro.emitir(solicitudEspana);

            comprobanteEspana.mostrarComprobante();

        } catch (IllegalArgumentException e) {

            System.out.println("Error al emitir comprobante: " + e.getMessage());
        }
    }
}
