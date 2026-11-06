public interface ConectorIoT {

    void conectar() throws ExcepcionConexion;

    void desconectar();

    void reconectar() throws ExcepcionConexion;

    EstadoConexion getEstado();

    String getProtocolo();
}
