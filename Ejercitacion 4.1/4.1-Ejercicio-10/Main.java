public class Main {

    public static void main(String[] args) {

        // Crear el gestor de riesgo
        GestorRiesgo gestor = new GestorRiesgo(
                PerfilRiesgo.MEDIO
        );

        // Crear los observadores
        ObservadorRegulatorio legal = new CumplimientoLegal();

        ObservadorRegulatorio lavado = new PrevencionLavado();

        ObservadorRegulatorio reportes = new ReportesRegulatorios();

        // Registrar los observadores
        gestor.suscribir(legal);
        gestor.suscribir(lavado);
        gestor.suscribir(reportes);

        // Cambiar el perfil del cliente
        RegistroAuditoria auditoria = gestor.cambiarPerfil(
                1001,
                PerfilRiesgo.CRITICO
        );

        // Mostrar el registro de auditoría
        auditoria.mostrarAuditoria();

        System.out.println(
                "\nPerfil actual: " + gestor.getPerfilActual()
        );
    }
}
