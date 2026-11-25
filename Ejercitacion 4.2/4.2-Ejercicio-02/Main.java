public class Main {

    public static void main(String[] args) {

        MonitorRed monitor = new MonitorRed();

        IconoConexion icono = new IconoConexion();
        TextoEstado texto = new TextoEstado();

        // Suscribir los componentes al monitor
        monitor.suscribir(icono);
        monitor.suscribir(texto);

        // Simular cambios en la conexión
        monitor.cambiarEstado(EstadoConexion.CONECTADO);

        monitor.cambiarEstado(EstadoConexion.INTERMITENTE);

        monitor.cambiarEstado(EstadoConexion.DESCONECTADO);

        // Eliminar un observador
        monitor.desuscribir(icono);

        // Solo se actualizará el texto
        monitor.cambiarEstado(EstadoConexion.CONECTADO);
    }
}
