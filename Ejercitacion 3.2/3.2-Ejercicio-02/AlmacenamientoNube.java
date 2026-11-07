public class AlmacenamientoNube implements Almacenamiento {

    @Override
    public void guardarArchivo(String nombreArchivo) {
        System.out.println("Subiendo archivo '" + nombreArchivo +
                "' al almacenamiento en la nube.");
    }

    @Override
    public void recuperarArchivo(String nombreArchivo) {
        System.out.println("Descargando archivo '" + nombreArchivo +
                "' desde el almacenamiento en la nube.");
    }
}
