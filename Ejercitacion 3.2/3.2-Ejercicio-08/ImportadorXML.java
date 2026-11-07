public class ImportadorXML implements Importador {

    @Override
    public void importar(String archivo) {
        System.out.println("Importando archivo XML: " + archivo);
        System.out.println("Leyendo datos mediante etiquetas XML.");
    }
}
