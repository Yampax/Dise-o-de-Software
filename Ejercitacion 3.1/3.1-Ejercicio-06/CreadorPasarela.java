public abstract class CreadorPasarela {

    protected abstract PasarelaPago crearPasarela();

    protected abstract double obtenerMontoMinimo();

    public Comprobante procesarOrden(OrdenCompra orden) {

        if (orden.getMonto() < obtenerMontoMinimo()) {
            throw new IllegalArgumentException(
                "El monto no cumple con el mínimo requerido."
            );
        }

        PasarelaPago pasarela = crearPasarela();

        return pasarela.procesarPago(orden.getMonto());
    }
}
