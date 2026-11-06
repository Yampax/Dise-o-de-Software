public class CreadorEstudiante extends CreadorPerfil {

    @Override
    public PerfilUsuario crearPerfil() {
        return new Estudiante();
    }
}
