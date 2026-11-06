public class CompresorTAR implements Compresor {

    @Override
    public void comprimir(String archivo) {

        System.out.println(
            "Comprimiendo " + archivo + " en formato TAR..."
        );
    }
}
