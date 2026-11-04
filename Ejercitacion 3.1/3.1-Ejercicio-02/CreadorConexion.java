public abstract class CreadorConexion {

    public abstract ConexionBD crearConexion();

    public void probarConexion() {

        ConexionBD conexion = crearConexion();

        conexion.ejecutarConsultaPrueba();
    }
}
