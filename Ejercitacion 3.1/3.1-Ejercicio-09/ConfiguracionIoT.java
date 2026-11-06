public class ConfiguracionIoT {

    private String servidor;
    private int puerto;
    private String usuario;
    private String contrasena;
    private boolean conexionSegura;

    public ConfiguracionIoT(String servidor, int puerto,
                            String usuario, String contrasena,
                            boolean conexionSegura) {

        this.servidor = servidor;
        this.puerto = puerto;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.conexionSegura = conexionSegura;
    }

    public String getServidor() {
        return servidor;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public boolean isConexionSegura() {
        return conexionSegura;
    }
}
