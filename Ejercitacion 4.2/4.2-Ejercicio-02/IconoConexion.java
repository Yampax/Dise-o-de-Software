public class IconoConexion implements ObservadorRed {

    @Override
    public void actualizar(EstadoConexion estado) {

        switch (estado) {
            case CONECTADO:
                System.out.println("Icono: Verde - Conexión activa");
                break;

            case DESCONECTADO:
                System.out.println("Icono: Rojo - Sin conexión");
                break;

            case INTERMITENTE:
                System.out.println("Icono: Amarillo - Conexión inestable");
                break;
        }
    }
}
