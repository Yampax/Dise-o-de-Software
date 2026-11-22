public class ServicioNotificaciones implements ObservadorEvento {

    @Override
    public void actualizar(Evento evento) {

        if (evento.getTipo().equals("UsuarioRegistrado")) {

            System.out.println(
                    "Notificación: nuevo usuario registrado: " +
                            evento.getPayload().get("nombre")
            );

        } else if (evento.getTipo().equals("PagoAprobado")) {

            System.out.println(
                    "Notificación: pago aprobado por $" +
                            evento.getPayload().get("monto")
            );
        }
    }
}
