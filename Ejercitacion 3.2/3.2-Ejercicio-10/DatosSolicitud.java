public final class DatosSolicitud {

    private final String dniPropietario;
    private final String nombrePropietario;
    private final String matriculaInmueble;
    private final String domicilio;

    public DatosSolicitud(
            String dniPropietario,
            String nombrePropietario,
            String matriculaInmueble,
            String domicilio) {

        if (dniPropietario == null
                || !dniPropietario.matches("\\d{7,8}")) {
            throw new IllegalArgumentException("DNI inválido.");
        }

        if (nombrePropietario == null || nombrePropietario.isBlank()
                || matriculaInmueble == null || matriculaInmueble.isBlank()
                || domicilio == null || domicilio.isBlank()) {
            throw new IllegalArgumentException(
                    "Los datos del propietario y del inmueble son obligatorios.");
        }

        this.dniPropietario = dniPropietario;
        this.nombrePropietario = nombrePropietario;
        this.matriculaInmueble = matriculaInmueble;
        this.domicilio = domicilio;
    }

    public String getDniPropietario() {
        return dniPropietario;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public String getMatriculaInmueble() {
        return matriculaInmueble;
    }

    public String getDomicilio() {
        return domicilio;
    }
}
