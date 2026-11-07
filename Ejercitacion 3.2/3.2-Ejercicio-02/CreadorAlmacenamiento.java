public abstract class CreadorAlmacenamiento {

    // Método fábrica.
    public abstract Almacenamiento crearAlmacenamiento();

    // Lógica que utiliza el almacenamiento.
    public void gestionarArchivos(String nombreArchivo) {

        Almacenamiento almacenamiento = crearAlmacenamiento();

        almacenamiento.guardarArchivo(nombreArchivo);
        almacenamiento.recuperarArchivo(nombreArchivo);
    }
}
