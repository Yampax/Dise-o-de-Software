public class AlmacenamientoLocal implements Almacenamiento {

    @Override
    public void guardarArchivo(String nombreArchivo) {
        System.out.println("Guardando archivo '" + nombreArchivo +
                "' en el disco local.");
    }

    @Override
    public void recuperarArchivo(String nombreArchivo) {
        System.out.println("Recuperando archivo '" + nombreArchivo +
                "' desde el disco local.");
    }
}
