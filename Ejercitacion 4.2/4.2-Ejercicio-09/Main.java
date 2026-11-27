public class Main {

    public static void main(String[] args) {

        BusEventos bus = new BusEventos();

        // Observadores
        AlertaCPU alertaCPU = new AlertaCPU();
        AlertaMemoria alertaMemoria = new AlertaMemoria();
        AlertaDisco alertaDisco = new AlertaDisco();
        ServicioMonitoreo monitoreo = new ServicioMonitoreo();

        // Suscripciones por categoría
        bus.suscribir("CPU", alertaCPU);
        bus.suscribir("MEMORIA", alertaMemoria);
        bus.suscribir("DISCO", alertaDisco);

        // Monitoreo escucha todas las categorías
        bus.suscribir("CPU", monitoreo);
        bus.suscribir("MEMORIA", monitoreo);
        bus.suscribir("DISCO", monitoreo);

        // Servidores
        Servidor servidor1 = new Servidor("Servidor-01", bus);
        Servidor servidor2 = new Servidor("Servidor-02", bus);

        // Publicación de alertas
        servidor1.generarAlerta(
                "CPU",
                "CRITICA",
                "Uso del procesador al 90%"
        );

        servidor2.generarAlerta(
                "MEMORIA",
                "CRITICA",
                "Memoria insuficiente"
        );

        servidor1.generarAlerta(
                "DISCO",
                "ALTA",
                "Fallo detectado en unidad de almacenamiento"
        );

        // Se elimina una suscripción
        bus.desuscribir("CPU", alertaCPU);

        // Nueva alerta de CPU
        servidor2.generarAlerta(
                "CPU",
                "ALTA",
                "Uso del procesador al 85%"
        );

        // Cierre del bus
        bus.cerrar();
    }
}
