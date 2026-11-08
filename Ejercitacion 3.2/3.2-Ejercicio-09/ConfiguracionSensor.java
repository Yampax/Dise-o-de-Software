public class ConfiguracionSensor {

    private final String direccion;
    private final int canal;
    private final int frecuencia;

    public ConfiguracionSensor(String direccion, int canal, int frecuencia) {
        this.direccion = direccion;
        this.canal = canal;
        this.frecuencia = frecuencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getCanal() {
        return canal;
    }

    public int getFrecuencia() {
        return frecuencia;
    }
}
