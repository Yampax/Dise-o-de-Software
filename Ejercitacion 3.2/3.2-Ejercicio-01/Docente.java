public class Docente implements PerfilUsuario {

    @Override
    public String consultarRol() {
        return "Docente";
    }

    @Override
    public String consultarPermisos() {
        return "Gestionar materias, publicar calificaciones y consultar estudiantes.";
    }
}
