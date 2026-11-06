public class CreadorDocente extends CreadorPerfil {

    @Override
    public PerfilUsuario crearPerfil() {
        return new Docente();
    }
}
