import java.util.HashMap;
import java.util.Map;

public class FabricaPagos {

    private Map<String, CreadorPasarela> creadores;

    public FabricaPagos() {

        creadores = new HashMap<>();

        creadores.put("tarjeta", new CreadorTarjeta());
        creadores.put("transferencia", new CreadorTransferencia());
        creadores.put("monedero", new CreadorMonedero());
    }

    public Comprobante procesarPago(OrdenCompra orden) {

        CreadorPasarela creador =
            creadores.get(orden.getMetodoPago().toLowerCase());

        if (creador == null) {
            throw new IllegalArgumentException(
                "El método de pago seleccionado no existe."
            );
        }

        return creador.procesarOrden(orden);
    }
}
