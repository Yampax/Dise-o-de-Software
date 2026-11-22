import java.util.HashMap;
import java.util.Map;

public class ServicioUsuarios {

    private final BusEventos bus;

    public ServicioUsuarios(BusEventos bus) {
        this.bus = bus;
    }

    public void registrarUsuario(String nombre, String correo) {

        Map<String, Object> datos = new HashMap<>();

        datos.put("nombre", nombre);
        datos.put("correo", correo);

        Evento evento = new Evento(
                "UsuarioRegistrado",
                datos
        );

        bus.publicar(evento);
    }
}
