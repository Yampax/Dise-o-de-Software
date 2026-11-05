public abstract class CreadorInterfaz {

    protected abstract Boton crearBoton();

    protected abstract CampoTexto crearCampoTexto();

    public void renderizarInterfaz() {

        Boton boton = crearBoton();
        CampoTexto campo = crearCampoTexto();

        boton.renderizar();
        campo.renderizar();

        boton.pulsar();
        campo.escribir("Hola mundo");
    }
}
