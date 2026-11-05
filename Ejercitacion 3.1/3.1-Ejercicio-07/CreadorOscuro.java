public class CreadorOscuro extends CreadorInterfaz {

    @Override
    protected Boton crearBoton() {
        return new BotonOscuro();
    }

    @Override
    protected CampoTexto crearCampoTexto() {
        return new CampoTextoOscuro();
    }
}
