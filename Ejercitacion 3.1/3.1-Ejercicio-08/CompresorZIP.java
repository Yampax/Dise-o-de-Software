public class CompresorZIP implements Compresor {

    @Override
    public void comprimir(String archivo) {

        System.out.println(
            "Comprimiendo " + archivo + " en formato ZIP..."
        );
    }
}
