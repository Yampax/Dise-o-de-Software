public class AuditorConsola implements Auditor {

    @Override
    public void actualizar(String mensaje) {
        System.out.println("[AUDITORÍA CONSOLA] " + mensaje);
    }
}
