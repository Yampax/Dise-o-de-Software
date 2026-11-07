public class ImportadorCSV implements Importador {

    @Override
    public void importar(String archivo) {
        System.out.println("Importando archivo CSV: " + archivo);
        System.out.println("Leyendo datos separados por comas.");
    }
}
