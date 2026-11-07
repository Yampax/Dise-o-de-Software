public class ProcesadorDatos {

    private final CreadorImportador creador;

    public ProcesadorDatos(CreadorImportador creador) {
        this.creador = creador;
    }

    public void procesar(String archivo) {

        Importador importador = creador.crearImportador();

        importador.importar(archivo);
    }
}
