public class Main {

    public static void main(String[] args) {

        FabricaInterfaz fabrica = new FabricaInterfaz();

        try {

            System.out.println("=== INTERFAZ OSCURA ===");

            CreadorInterfaz interfazOscura =
                fabrica.obtenerCreador("oscuro");

            interfazOscura.renderizarInterfaz();


            System.out.println("\n=== INTERFAZ MINIMALISTA ===");

            CreadorInterfaz interfazMinimalista =
                fabrica.obtenerCreador("minimalista");

            interfazMinimalista.renderizarInterfaz();

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
