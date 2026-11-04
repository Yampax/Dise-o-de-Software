public class CreadorPostgreSQL extends CreadorConexion {

    @Override
    public ConexionBD crearConexion() {
        return new ConexionPostgreSQL();
    }
}
