public interface ObservadorPrecio {

    void actualizar(String nombreProducto,
                    double precioAnterior,
                    double precioNuevo,
                    double porcentajeRebaja);
}
