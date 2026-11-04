public class Main {

    public static void main(String[] args) {

        CreadorConexion creador;

        // Probar conexión SQLite
        creador = new CreadorSQLite();
        creador.probarConexion();

        // Probar conexión PostgreSQL
        creador = new CreadorPostgreSQL();
        creador.probarConexion();
    }
}
