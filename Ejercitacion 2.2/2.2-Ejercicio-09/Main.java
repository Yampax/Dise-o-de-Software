public class Main {

    public static void main(String[] args) {

        Thread[] hilos = new Thread[10];
        GestorImpresion[] gestores = new GestorImpresion[10];

        String[] sectores = {
                "Recepción", "Facturación", "Archivo"
        };

        // Crear diez hilos
        for (int i = 0; i < 10; i++) {

            final int numeroHilo = i + 1;
            final String sector = sectores[i % 3];

            hilos[i] = new Thread(() -> {

                // Cada hilo obtiene la instancia Singleton
                GestorImpresion gestor =
                        GestorImpresion.getInstancia();

                gestores[numeroHilo - 1] = gestor;

                // Cada hilo envía tres documentos
                for (int j = 1; j <= 3; j++) {

                    Documento documento = new Documento(
                            "T" + numeroHilo + "-D" + j,
                            "Documento " + j,
                            sector,
                            j + 2
                    );

                    gestor.encolar(documento);
                }
            });

            hilos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Thread hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Se interrumpió la espera.");
                return;
            }
        }

        // Comprobar que todos obtuvieron el mismo objeto
        boolean mismaInstancia = true;

        for (int i = 1; i < gestores.length; i++) {
            if (gestores[i] != gestores[0]) {
                mismaInstancia = false;
            }
        }

        System.out.println("\n¿Todos usan la misma instancia? "
                + mismaInstancia);

        // Procesar todos los documentos
        gestores[0].procesarCola();

        // Mostrar informe
        System.out.println("\nINFORME DE IMPRESIÓN:");

        for (Documento documento :
                gestores[0].obtenerInforme()) {
            System.out.println(documento);
        }

        System.out.println("\nTotal de documentos procesados: "
                + gestores[0].obtenerInforme().size());
    }
}
