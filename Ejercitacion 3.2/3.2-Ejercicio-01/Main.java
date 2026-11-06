public class Main {

    public static void main(String[] args) {

        // Crear perfil de estudiante.
        CreadorPerfil creadorEstudiante = new CreadorEstudiante();
        PerfilUsuario estudiante = creadorEstudiante.crearPerfil();

        // Crear perfil de docente.
        CreadorPerfil creadorDocente = new CreadorDocente();
        PerfilUsuario docente = creadorDocente.crearPerfil();

        // Mostrar información de los perfiles.
        System.out.println("=== PERFIL DE ESTUDIANTE ===");
        System.out.println("Rol: " + estudiante.consultarRol());
        System.out.println("Permisos: " + estudiante.consultarPermisos());

        System.out.println();

        System.out.println("=== PERFIL DE DOCENTE ===");
        System.out.println("Rol: " + docente.consultarRol());
        System.out.println("Permisos: " + docente.consultarPermisos());
    }
}
