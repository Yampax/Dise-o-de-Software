public class Main {

    public static void main(String[] args) {

        FabricaCompresores fabrica =
            new FabricaCompresores();

        try {

            CreadorCompresor creadorZIP =
                fabrica.obtenerCreador("ZIP");

            SistemaArchivos sistemaZIP =
                new SistemaArchivos(creadorZIP);

            sistemaZIP.comprimir("documento.pdf");


            CreadorCompresor creadorTAR =
                fabrica.obtenerCreador("TAR");

            SistemaArchivos sistemaTAR =
                new SistemaArchivos(creadorTAR);

            sistemaTAR.comprimir("imagenes");


            CreadorCompresor creadorGZ =
                fabrica.obtenerCreador("GZ");

            SistemaArchivos sistemaGZ =
                new SistemaArchivos(creadorGZ);

            sistemaGZ.comprimir("respaldo.sql");

        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
