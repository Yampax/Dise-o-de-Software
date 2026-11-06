public class ValidadorFiscal {

    public static void validar(SolicitudFiscal solicitud) {

        if (solicitud == null) {
            throw new IllegalArgumentException("La solicitud no puede ser nula.");
        }

        if (solicitud.getPais() == null ||
            solicitud.getPais().isBlank()) {
            throw new IllegalArgumentException("Debe indicar el país.");
        }

        if (solicitud.getRazonSocial() == null ||
            solicitud.getRazonSocial().isBlank()) {
            throw new IllegalArgumentException("Falta la razón social.");
        }

        if (solicitud.getIdentificadorEmisor() == null ||
            solicitud.getIdentificadorEmisor().isBlank()) {
            throw new IllegalArgumentException("Falta el identificador fiscal del emisor.");
        }

        if (solicitud.getDomicilio() == null ||
            solicitud.getDomicilio().isBlank()) {
            throw new IllegalArgumentException("Falta el domicilio del emisor.");
        }

        if (solicitud.getNombreReceptor() == null ||
            solicitud.getNombreReceptor().isBlank()) {
            throw new IllegalArgumentException("Falta el nombre del receptor.");
        }

        if (solicitud.getIdentificadorReceptor() == null ||
            solicitud.getIdentificadorReceptor().isBlank()) {
            throw new IllegalArgumentException("Falta el identificador del receptor.");
        }

        if (solicitud.getMoneda() == null ||
            solicitud.getMoneda().isBlank()) {
            throw new IllegalArgumentException("Debe indicar la moneda.");
        }

        double subtotal = solicitud.getSubtotal();
        double impuesto = solicitud.getImpuesto();
        double total = solicitud.getTotal();

        if (!Double.isFinite(subtotal) ||
            !Double.isFinite(impuesto) ||
            !Double.isFinite(total)) {
            throw new IllegalArgumentException("Los importes deben ser números válidos.");
        }

        if (subtotal < 0 || impuesto < 0 || total <= 0) {
            throw new IllegalArgumentException("Los importes no pueden ser negativos o inválidos.");
        }

        if (Math.abs((subtotal + impuesto) - total) > 0.001) {
            throw new IllegalArgumentException("El total no coincide con subtotal más impuesto.");
        }

        String pais = solicitud.getPais().toUpperCase();

        if (pais.equals("ARGENTINA")) {

            if (!solicitud.getIdentificadorEmisor().matches("\\d{11}")) {
                throw new IllegalArgumentException("El CUIT debe tener 11 dígitos.");
            }

            if (!solicitud.getMoneda().equalsIgnoreCase("ARS")) {
                throw new IllegalArgumentException("Argentina debe utilizar ARS.");
            }

        } else if (pais.equals("ESPAÑA") || pais.equals("ESPANA")) {

            if (solicitud.getIdentificadorEmisor().length() < 8) {
                throw new IllegalArgumentException("Identificador fiscal español inválido.");
            }

            if (!solicitud.getMoneda().equalsIgnoreCase("EUR")) {
                throw new IllegalArgumentException("España debe utilizar EUR.");
            }

        } else {
            throw new IllegalArgumentException("País no soportado.");
        }
    }
}
