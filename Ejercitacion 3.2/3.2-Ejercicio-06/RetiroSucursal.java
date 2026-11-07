public class RetiroSucursal implements ServicioEnvio {

    @Override
    public double calcularCosto(DatosEnvio datos) {
        return 2500 + (datos.getPeso() * 500);
    }

    @Override
    public int calcularTiempo(DatosEnvio datos) {
        return 2;
    }

    @Override
    public void mostrarInformacion(DatosEnvio datos) {
        System.out.println("=== RETIRO EN SUCURSAL ===");
        System.out.println("Costo: $" + calcularCosto(datos));
        System.out.println("Disponible en: "
                + calcularTiempo(datos) + " días");
        System.out.println("Localidad: " + datos.getLocalidad());
    }
}
