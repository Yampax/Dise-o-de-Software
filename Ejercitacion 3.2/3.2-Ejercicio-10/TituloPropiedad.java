public abstract class TituloPropiedad {

    private final String propietario;
    private final String matricula;
    private final String jurisdiccion;
    private final String codigoNotarial;
    private final String firmaDigital;

    protected TituloPropiedad(
            DatosSolicitud datos,
            ContextoJurisdiccion contexto,
            String firmaDigital) {

        this.propietario = datos.getNombrePropietario();
        this.matricula = datos.getMatriculaInmueble();
        this.jurisdiccion = contexto.getJurisdiccion();
        this.codigoNotarial = contexto.getCodigoNotarial();
        this.firmaDigital = firmaDigital;
    }

    public void mostrarTitulo() {
        System.out.println("Propietario: " + propietario);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Jurisdicción: " + jurisdiccion);
        System.out.println("Código notarial: " + codigoNotarial);
        System.out.println("Firma digital: " + firmaDigital);
    }

    public abstract String obtenerFormato();
}
