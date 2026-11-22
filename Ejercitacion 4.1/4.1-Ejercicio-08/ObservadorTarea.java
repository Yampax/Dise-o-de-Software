public interface ObservadorTarea {
    void actualizar(String nombreTarea,
                    EstadoTarea estadoAnterior,
                    EstadoTarea estadoNuevo);
}
