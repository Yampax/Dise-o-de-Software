public class Servidor {

    private String nombre;
    private BusEventos bus;

    public Servidor(String nombre, BusEventos bus) {
        this.nombre = nombre;
        this.bus = bus;
    }

    public void generarAlerta(String tipo, String severidad,
                              String descripcion) {

        Evento evento = new Evento(
                tipo,
                severidad,
                nombre + ": " + descripcion
        );

        System.out.println("\n[" + nombre + "] Publicando alerta: " + tipo);

        bus.publicar(evento);
    }
}
