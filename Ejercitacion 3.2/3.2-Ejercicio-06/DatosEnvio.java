public class DatosEnvio {

    private double peso;
    private double distancia;
    private String provincia;
    private String localidad;
    private boolean sucursalDisponible;

    public DatosEnvio(double peso, double distancia,
                      String provincia, String localidad,
                      boolean sucursalDisponible) {
        this.peso = peso;
        this.distancia = distancia;
        this.provincia = provincia;
        this.localidad = localidad;
        this.sucursalDisponible = sucursalDisponible;
    }

    public double getPeso() {
        return peso;
    }

    public double getDistancia() {
        return distancia;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public boolean isSucursalDisponible() {
        return sucursalDisponible;
    }
}
