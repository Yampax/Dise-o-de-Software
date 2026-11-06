public class Estudiante implements PerfilUsuario {

    @Override
    public String consultarRol() {
        return "Estudiante";
    }

    @Override
    public String consultarPermisos() {
        return "Consultar materias, inscribirse a cursadas y consultar calificaciones.";
    }
}
