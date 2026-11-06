public class ValidadorFiscal {

    public static void validar(SolicitudFiscal solicitud)
            throws ExcepcionFiscal {

        if (solicitud == null) {
            throw new ExcepcionFiscal(
                "La solicitud fiscal no puede ser nula."
            );
        }

        if (solicitud.getPais() == null
                || solicitud.getPais().isBlank()) {

            throw new ExcepcionFiscal(
                "Debe especificarse el país emisor."
            );
        }

        if (solicitud.getEmisor() == null
                || solicitud.getReceptor() == null
                || solicitud.getDatos() == null) {

            throw new ExcepcionFiscal(
                "Faltan datos obligatorios de la solicitud."
            );
        }

        DatosEmisor emisor = solicitud.getEmisor();
        DatosReceptor receptor = solicitud.getReceptor();
        DatosTributarios datos = solicitud.getDatos();

        if (emisor.getRazonSocial() == null
                || emisor.getRazonSocial().isBlank()
                || emisor.getDomicilio() == null
                || emisor.getDomicilio().isBlank()
                || receptor.getNombre() == null
                || receptor.getNombre().isBlank()
                || receptor.getIdentificadorFiscal() == null
                || receptor.getIdentificadorFiscal().isBlank()) {

            throw new ExcepcionFiscal(
                "Los datos del emisor o receptor están incompletos."
            );
        }

        if (datos.getSubtotal() < 0
                || datos.getImpuesto() < 0
                || datos.getTotal() <= 0
                || !Double.isFinite(datos.getSubtotal())
                || !Double.isFinite(datos.getImpuesto())
                || !Double.isFinite(datos.getTotal())) {

            throw new ExcepcionFiscal(
                "Los importes tributarios no son válidos."
            );
        }

        double totalCalculado =
            datos.getSubtotal() + datos.getImpuesto();

        if (Math.abs(totalCalculado - datos.getTotal()) > 0.001) {

            throw new ExcepcionFiscal(
                "Los importes no coinciden con el total declarado."
            );
        }

        validarJurisdiccion(solicitud);
    }

    private static void validarJurisdiccion(
            SolicitudFiscal solicitud
    ) throws ExcepcionFiscal {

        String pais = solicitud.getPais().toUpperCase();

        String identificador =
            solicitud.getEmisor().getIdentificadorFiscal();

        String moneda =
            solicitud.getDatos().getMoneda();

        if (pais.equals("ARGENTINA")) {

            if (!identificador.matches("\\d{11}")) {
                throw new ExcepcionFiscal(
                    "El CUIT del emisor debe tener 11 dígitos."
                );
            }

            if (!"ARS".equals(moneda)) {
                throw new ExcepcionFiscal(
                    "La moneda de esta solicitud debe ser ARS."
                );
            }

        } else if (pais.equals("ESPANA")) {

            if (identificador.length() < 8) {
                throw new ExcepcionFiscal(
                    "El identificador fiscal español es inválido."
                );
            }

            if (!"EUR".equals(moneda)) {
                throw new ExcepcionFiscal(
                    "La moneda de esta solicitud debe ser EUR."
                );
            }

        } else {

            throw new ExcepcionFiscal(
                "Jurisdicción fiscal no soportada."
            );
        }
    }
}
