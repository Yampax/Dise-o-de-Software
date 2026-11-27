public class ModuloEstadisticas implements ObservadorStock {

    @Override
    public void actualizarStock(String producto, int stockActual) {

        System.out.println("[Estadísticas] Registrando stock de "
                + producto + ": " + stockActual);

        if (stockActual < 5) {
            System.out.println("[Estadísticas] Stock bajo detectado.");
        }
    }
}
