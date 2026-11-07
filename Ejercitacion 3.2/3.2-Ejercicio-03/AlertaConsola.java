public class AlertaConsola implements CanalAlerta {

    @Override
    public void enviarAlerta(String mensaje) {
        System.out.println("[ALERTA POR CONSOLA] " + mensaje);
    }
}
