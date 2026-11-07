public abstract class CreadorComprobante {

    // Método fábrica.
    public abstract GeneradorComprobante crearGenerador();

    // Proceso general de generación.
    public final void generarComprobante(DatosFactura datos) {

        if (datos == null) {
            throw new IllegalArgumentException("Los datos no pueden ser nulos.");
        }

        GeneradorComprobante generador = crearGenerador();

        generador.generar(datos);
    }
}
