public class CreadorSucursal extends CreadorEnvio {

    @Override
    public ServicioEnvio crearServicio() {
        return new RetiroSucursal();
    }
}
