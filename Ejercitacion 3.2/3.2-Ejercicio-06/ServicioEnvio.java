public interface ServicioEnvio {

    double calcularCosto(DatosEnvio datos);

    int calcularTiempo(DatosEnvio datos);

    void mostrarInformacion(DatosEnvio datos);
}
