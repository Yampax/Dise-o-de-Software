public class Main {

    public static void main(String[] args) {

        RegistroInsumos deposito =
                RegistroInsumos.getInstancia();

        RegistroInsumos consultorios =
                RegistroInsumos.getInstancia();

        RegistroInsumos laboratorio =
                RegistroInsumos.getInstancia();

        // Verificar que los tres sectores comparten el registro
        System.out.println("¿Misma instancia? " +
                (deposito == consultorios &&
                        consultorios == laboratorio));

        // Depósito registra el saldo inicial
        deposito.registrarMovimiento(
                "INS-001", "ENTRADA", 100, "Depósito"
        );

        deposito.registrarMovimiento(
                "INS-002", "ENTRADA", 50, "Depósito"
        );

        // Consultorios registra una salida
        consultorios.registrarMovimiento(
                "INS-001", "SALIDA", 20, "Consultorios"
        );

        // Laboratorio registra movimientos
        laboratorio.registrarMovimiento(
                "INS-001", "SALIDA", 15, "Laboratorio"
        );

        laboratorio.registrarMovimiento(
                "INS-002", "SALIDA", 10, "Laboratorio"
        );

        // Intentar una salida superior al saldo disponible
        boolean resultado = consultorios.registrarMovimiento(
                "INS-001", "SALIDA", 100, "Consultorios"
        );

        System.out.println("\n¿Se registró la salida? " + resultado);

        // Consultar saldos
        System.out.println("\nSaldo INS-001: " +
                deposito.consultarSaldo("INS-001"));

        System.out.println("Saldo INS-002: " +
                deposito.consultarSaldo("INS-002"));

        // Consultar historial completo
        System.out.println("\nHISTORIAL COMPLETO:");

        for (Movimiento movimiento : deposito.obtenerHistorial()) {
            System.out.println(movimiento);
        }

        // Filtrar por sector
        System.out.println("\nMOVIMIENTOS DE LABORATORIO:");

        for (Movimiento movimiento :
                deposito.filtrarPorSector("Laboratorio")) {
            System.out.println(movimiento);
        }

        // Filtrar por insumo
        System.out.println("\nMOVIMIENTOS DEL INS-001:");

        for (Movimiento movimiento :
                deposito.filtrarPorInsumo("INS-001")) {
            System.out.println(movimiento);
        }
    }
}
