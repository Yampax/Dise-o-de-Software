public class TextoEstado implements ObservadorRed {

    @Override
    public void actualizar(EstadoConexion estado) {

        switch (estado) {
            case CONECTADO:
                System.out.println("Texto: Conectado a la red");
                break;

            case DESCONECTADO:
                System.out.println("Texto: No hay conexión de red");
                break;

            case INTERMITENTE:
                System.out.println("Texto: La conexión es intermitente");
                break;
        }
    }
}
