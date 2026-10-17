public class Main {
    public static void main(String[] args) {

        Configuración config1 = Configuración.getInstance();

        System.out.println(
                config1.getPropiedad("aplicacion.nombre"));

        System.out.println(
                config1.getPropiedad("servidor.puerto"));

        // Solicitamos nuevamente la instancia
        Configuración config2 = Configuración.getInstance();

        // Comprobamos si es el mismo objeto
        System.out.println(config1 == config2);
    }
}
