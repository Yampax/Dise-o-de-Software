public class Main {

    public static void main(String[] args) {

        SelectorFactorias selector = new SelectorFactorias();

        // Seleccionar el formato deseado
        TipoFormato formato = TipoFormato.JSON;

        // Obtener el creador correspondiente
        CreadorImportador creador =
                selector.obtenerCreador(formato);

        // Crear el procesador e inyectar el creador
        ProcesadorDatos procesador =
                new ProcesadorDatos(creador);

        // Procesar el archivo
        procesador.procesar("datos.json");
    }
}
