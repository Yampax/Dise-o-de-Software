public abstract class CreadorCompresor {

    protected abstract Compresor crearCompresor();

    public void comprimirArchivo(String archivo) {

        Compresor compresor = crearCompresor();

        compresor.comprimir(archivo);
    }
}
