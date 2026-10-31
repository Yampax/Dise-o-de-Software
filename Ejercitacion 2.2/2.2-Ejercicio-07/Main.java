public class Main {

    public static void main(String[] args) {

        Terminal terminal1 = new Terminal("Terminal 1");
        Terminal terminal2 = new Terminal("Terminal 2");
        Terminal terminal3 = new Terminal("Terminal 3");

        // Simulación de 20 solicitudes alternadas
        for (int i = 0; i < 20; i++) {

            if (i % 3 == 0) {
                terminal1.solicitarNumero();
            } else if (i % 3 == 1) {
                terminal2.solicitarNumero();
            } else {
                terminal3.solicitarNumero();
            }
        }

        // Consultar el último número emitido
        GeneradorNumeros generador =
                GeneradorNumeros.getInstancia();

        System.out.println("\nÚltimo número emitido: " +
                generador.consultarUltimoNumero());

        // Mostrar historial
        System.out.println("\nHistorial de números:");

        for (String registro : generador.obtenerHistorial()) {
            System.out.println(registro);
        }
    }
}

