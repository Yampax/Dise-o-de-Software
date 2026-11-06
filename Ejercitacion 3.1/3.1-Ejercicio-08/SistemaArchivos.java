public class SistemaArchivos {

    private CreadorCompresor creador;

    public SistemaArchivos(CreadorCompresor creador) {

        this.creador = creador;
    }

    public void comprimir(String archivo) {

        creador.comprimirArchivo(archivo);
    }
}
