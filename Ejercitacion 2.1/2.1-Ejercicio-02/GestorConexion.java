public class GestorConexion {

    private static final GestorConexion instancia = new GestorConexion();

    private boolean conexionActiva;

    private GestorConexion(){
        conexionActiva = true;
        System.out.println("Conexión a la base de datos establecida.");
    }

    public static GestorConexion getInstancia() {
        return instancia;
    }

    public void consultar(String consulta) {
        if (conexionActiva) {
            System.out.println("Ejecutando consulta: " + consulta);
        } else {
            System.out.println("No hay una conexión activa.");
        }
    }

    public void actualizar(String operacion) {
        if (conexionActiva) {
            System.out.println("Ejecutando actualización: " + operacion);
        } else {
            System.out.println("No hay una conexión activa.");
        }
    }

    public boolean isConexionActiva() {
        return conexionActiva;
    }

    public static void main(String[] args) {

        GestorConexion gestor1 = GestorConexion.getInstancia();

        gestor1.consultar("SELECT * FROM clientes");

        gestor1.actualizar(
                "UPDATE clientes SET nombre = 'Juan' WHERE id = 1"
        );

        GestorConexion gestor2 = GestorConexion.getInstancia();

        System.out.println(
                "¿Es la misma instancia? " + (gestor1 == gestor2)
        );

        System.out.println(
                "¿La conexión está activa? " + gestor2.isConexionActiva()
        );
    }
}
