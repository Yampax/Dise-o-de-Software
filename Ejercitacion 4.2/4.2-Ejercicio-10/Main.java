public class Main {

    public static void main(String[] args) {

        GestorRiesgo gestor = new GestorRiesgo();

        // Crear observadores
        ModuloCumplimiento cumplimiento = new ModuloCumplimiento();

        ModuloPrevencionLavado aml =
                new ModuloPrevencionLavado();

        ModuloLegal legal = new ModuloLegal();

        ModuloRegulatorio regulatorio =
                new ModuloRegulatorio();

        // Registrar cuenta
        gestor.registrarCuenta(
                "CORP-001",
                PerfilRiesgo.BAJO
        );

        // Suscribir observadores
        gestor.suscribir(cumplimiento);
        gestor.suscribir(aml);
        gestor.suscribir(legal);
        gestor.suscribir(regulatorio);

        // Modificar el perfil de riesgo
        gestor.modificarRiesgo(
                "CORP-001",
                PerfilRiesgo.CRITICO,
                "Operaciones financieras inusuales"
        );

        // Mostrar auditoría
        gestor.getAuditoria().mostrarRegistros();
    }
}
