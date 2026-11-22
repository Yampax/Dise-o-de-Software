import java.util.HashMap;
import java.util.Map;

public class ServicioPagos {

    private final BusEventos bus;

    public ServicioPagos(BusEventos bus) {
        this.bus = bus;
    }

    public void aprobarPago(int idUsuario, double monto) {

        Map<String, Object> datos = new HashMap<>();

        datos.put("idUsuario", idUsuario);
        datos.put("monto", monto);

        Evento evento = new Evento(
                "PagoAprobado",
                datos
        );

        bus.publicar(evento);
    }
}
