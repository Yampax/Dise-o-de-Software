public class CreadorMinimalista extends CreadorInterfaz {

    @Override
    protected Boton crearBoton() {
        return new BotonMinimalista();
    }

    @Override
    protected CampoTexto crearCampoTexto() {
        return new CampoTextoMinimalista();
    }
}
