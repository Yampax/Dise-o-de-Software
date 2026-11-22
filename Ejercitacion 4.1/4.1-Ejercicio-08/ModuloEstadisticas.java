public class ModuloEstadisticas implements ObservadorTarea {

    @Override
    public void actualizar(String nombreTarea,
                           EstadoTarea estadoAnterior,
                           EstadoTarea estadoNuevo) {

        System.out.println(
                "Estadísticas actualizadas: La tarea '" +
                nombreTarea + "' pasó de " +
                estadoAnterior + " a " + estadoNuevo
        );
    }
}
