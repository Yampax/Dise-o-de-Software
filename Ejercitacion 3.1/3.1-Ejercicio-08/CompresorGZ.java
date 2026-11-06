public class CompresorGZ implements Compresor {

    @Override
    public void comprimir(String archivo) {

        System.out.println(
            "Comprimiendo " + archivo + " en formato GZ..."
        );
    }
}
