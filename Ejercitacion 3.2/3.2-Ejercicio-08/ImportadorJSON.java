public class ImportadorJSON implements Importador {

    @Override
    public void importar(String archivo) {
        System.out.println("Importando archivo JSON: " + archivo);
        System.out.println("Leyendo datos mediante estructuras JSON.");
    }
}
