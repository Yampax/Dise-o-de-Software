public class EnvioPostal implements ServicioEnvio {

    @Override
    public double calcularCosto(DatosEnvio datos) {
        return 5000 + (datos.getPeso() * 1200)
                + (datos.getDistancia() * 35);
    }

    @Override
    public int calcularTiempo(DatosEnvio datos) {
        return 3 + (int) Math.ceil(datos.getDistancia() / 300);
    }

    @Override
    public void mostrarInformacion(DatosEnvio datos) {
        System.out.println("=== CORREO POSTAL ===");
        System.out.println("Costo: $" + calcularCosto(datos));
        System.out.println("Entrega estimada: "
                + calcularTiempo(datos) + " días");
    }
}
