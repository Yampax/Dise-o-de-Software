public interface ObservadorRegulatorio {
    String getNombre();
    void procesar(CambioRiesgo cambio) throws Exception;
}
