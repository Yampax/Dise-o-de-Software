public class EnvioExpreso implements ServicioEnvio {

    @Override
    public double calcularCosto(DatosEnvio datos) {
        double costo = 9000 + (datos.getPeso() * 1800)
                + (datos.getDistancia() * 60);

        return costo * 1.25;
    }

    @Override
    public int calcularTiempo(DatosEnvio datos) {
        return 1 + (int) Math.ceil(datos.getDistancia() / 500);
    }

    @Override
    public void mostrarInformacion(DatosEnvio datos) {
        System.out.println("=== ENVÍO EXPRESO ===");
        System.out.println("Costo: $" + calcularCosto(datos));
        System.out.println("Entrega estimada: "
                + calcularTiempo(datos) + " días");
    }
}
