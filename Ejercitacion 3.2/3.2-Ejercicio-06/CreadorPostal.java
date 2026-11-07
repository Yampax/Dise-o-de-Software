public class CreadorPostal extends CreadorEnvio {

    @Override
    public ServicioEnvio crearServicio() {
        return new EnvioPostal();
    }
}
