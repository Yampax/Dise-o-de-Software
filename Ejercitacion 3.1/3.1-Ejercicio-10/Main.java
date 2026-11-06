public class Main {

    public static void main(String[] args) {

        RegistroFactorias registro = new RegistroFactorias();

        // Servicios de demostración
        ServicioAutorizacion autorizacion =
            new AutorizacionDemo();

        ServicioFirmaDigital firma =
            new FirmaDemo();

        // Registro de factorías
        registro.registrar(
            "ARGENTINA",
            new CreadorArgentina(autorizacion, firma)
        );

        registro.registrar(
            "ESPANA",
            new CreadorEspana(autorizacion, firma)
        );

        try {

            // Solicitud para Argentina
            SolicitudFiscal solicitudArgentina =
                new SolicitudFiscal(
                    "ARGENTINA",

                    new DatosEmisor(
                        "Empresa Argentina S.A.",
                        "30712345678",
                        "Mendoza, Argentina"
                    ),

                    new DatosReceptor(
                        "Cliente Argentina",
                        "20123456789"
                    ),

                    new DatosTributarios(
                        100000,
                        21000,
                        121000,
                        "ARS"
                    )
                );

            // Solicitud para España
            SolicitudFiscal solicitudEspana =
                new SolicitudFiscal(
                    "ESPANA",

                    new DatosEmisor(
                        "Empresa Española S.L.",
                        "B12345678",
                        "Madrid, España"
                    ),

                    new DatosReceptor(
                        "Cliente Español",
                        "12345678Z"
                    ),

                    new DatosTributarios(
                        1000,
                        210,
                        1210,
                        "EUR"
                    )
                );

            // Emisión de comprobantes
            ComprobanteFiscal comprobanteArgentina =
                registro.emitir(solicitudArgentina);

            ComprobanteFiscal comprobanteEspana =
                registro.emitir(solicitudEspana);

            // Mostrar resultados
            comprobanteArgentina.mostrarComprobante();

            System.out.println();

            comprobanteEspana.mostrarComprobante();

        } catch (ExcepcionFiscal e) {

            System.out.println(
                "Error fiscal: " + e.getMessage()
            );
        }
    }
}
