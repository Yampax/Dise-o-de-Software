public class CreadorExpreso extends CreadorEnvio {

    @Override
    public ServicioEnvio crearServicio() {
        return new EnvioExpreso();
    }
}
