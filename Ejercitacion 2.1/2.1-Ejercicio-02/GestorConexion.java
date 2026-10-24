public class GestorConexion {

    private static GestorConexion instancia = null;

    private boolean conectado;
    private String nombreBaseDatos;

    // Constructor privado
    private GestorConexion() {
        nombreBaseDatos = "BaseDeDatosLocal";
        conectado = false;
        System.out.println("Gestor de conexión inicializado.");
    }

    // Obtiene la única instancia
    public static synchronized GestorConexion getInstancia() {
        if (instancia == null) {
            instancia = new GestorConexion();
        }
        return instancia;
    }

    // Simula la apertura de una conexión
    public synchronized void conectar() {
        if (!conectado) {
            conectado = true;
            System.out.println("Conexión establecida con "
                    + nombreBaseDatos + ".");
        } else {
            System.out.println("La conexión ya está activa.");
        }
    }

    // Simula una consulta
    public synchronized void consultar(String consulta) {
        if (!conectado) {
            System.out.println("Error: no hay una conexión activa.");
            return;
        }

        if (consulta == null || consulta.isBlank()) {
            System.out.println("La consulta no puede estar vacía.");
            return;
        }

        System.out.println("Ejecutando consulta: " + consulta);
        System.out.println("Consulta realizada correctamente.");
    }

    // Simula una actualización
    public synchronized void actualizar(String operacion) {
        if (!conectado) {
            System.out.println("Error: no hay una conexión activa.");
            return;
        }

        if (operacion == null || operacion.isBlank()) {
            System.out.println("La operación no puede estar vacía.");
            return;
        }

        System.out.println("Ejecutando actualización: " + operacion);
        System.out.println("Actualización realizada correctamente.");
    }

    // Simula el cierre de la conexión
    public synchronized void desconectar() {
        if (conectado) {
            conectado = false;
            System.out.println("Conexión cerrada.");
        } else {
            System.out.println("La conexión ya está cerrada.");
        }
    }

    public synchronized boolean estaConectado() {
        return conectado;
    }

    public static void main(String[] args) {

        GestorConexion gestor1 = GestorConexion.getInstancia();

        gestor1.conectar();
        gestor1.consultar("SELECT * FROM usuarios");
        gestor1.actualizar(
                "UPDATE usuarios SET activo = true WHERE id = 1"
        );

        GestorConexion gestor2 = GestorConexion.getInstancia();

        System.out.println("¿Es la misma instancia? "
                + (gestor1 == gestor2));

        System.out.println("¿Está conectado? "
                + gestor2.estaConectado());

        gestor2.desconectar();
    }
}
