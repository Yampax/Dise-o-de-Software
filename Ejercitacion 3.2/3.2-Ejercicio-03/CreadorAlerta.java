public abstract class CreadorAlerta {

    // Método fábrica.
    public abstract CanalAlerta crearAlerta();

    // Operación que utiliza el canal de salida.
    public void enviarMensaje(String mensaje) {

        CanalAlerta alerta = crearAlerta();

        alerta.enviarAlerta(mensaje);
    }
}
