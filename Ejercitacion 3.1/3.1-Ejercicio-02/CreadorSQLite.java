public class CreadorSQLite extends CreadorConexion {

    @Override
    public ConexionBD crearConexion() {
        return new ConexionSQLite();
    }
}
