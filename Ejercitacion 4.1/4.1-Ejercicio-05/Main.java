public class Main {

    public static void main(String[] args) {

        // Creamos dos sensores en distintas ubicaciones
        SensorHumo sensorPlantaBaja =
                new SensorHumo("Planta baja - Pasillo principal");

        SensorHumo sensorSegundoPiso =
                new SensorHumo("Segundo piso - Oficina 204");

        // Creamos los sistemas de respuesta
        CentralAlarmas central = new CentralAlarmas();
        SistemaRociadores rociadores = new SistemaRociadores();
        ServicioConserjeria conserjeria = new ServicioConserjeria();

        // Registramos los sistemas en el sensor de planta baja
        sensorPlantaBaja.suscribir(central);
        sensorPlantaBaja.suscribir(rociadores);
        sensorPlantaBaja.suscribir(conserjeria);

        // Registramos los sistemas en el sensor del segundo piso
        sensorSegundoPiso.suscribir(central);
        sensorSegundoPiso.suscribir(rociadores);
        sensorSegundoPiso.suscribir(conserjeria);

        // Simulamos una detección de humo
        sensorPlantaBaja.detectarHumo();

        // Simulamos otra detección
        sensorSegundoPiso.detectarHumo();
    }
}
