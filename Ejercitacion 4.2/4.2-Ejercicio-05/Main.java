public class Main {

    public static void main(String[] args) {

        // Crear el sensor
        SensorLuz sensor = new SensorLuz();

        // Crear los dispositivos
        PersianasMotorizadas persianas = new PersianasMotorizadas();

        LucesInteriores luces = new LucesInteriores();

        AlarmaLuminosidad alarma = new AlarmaLuminosidad();

        // Suscribir los dispositivos al sensor
        sensor.suscribir(persianas);
        sensor.suscribir(luces);
        sensor.suscribir(alarma);

        // Simular cambios de luminosidad
        sensor.actualizarLuminosidad(850);

        sensor.actualizarLuminosidad(200);

        sensor.actualizarLuminosidad(500);

        // Desuscribir la alarma
        sensor.desuscribir(alarma);

        System.out.println("\nLa alarma dejó de recibir notificaciones.");

        // Los demás dispositivos siguen funcionando
        sensor.actualizarLuminosidad(950);
    }
}
