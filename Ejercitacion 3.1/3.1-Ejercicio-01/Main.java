public class Main {

    public static void main(String[] args) {

        CreadorDocumento creador;

        // Crear documento de texto plano
        creador = new CreadorTextoPlano();
        creador.abrirDocumento();

        // Crear documento enriquecido
        creador = new CreadorEnriquecido();
        creador.abrirDocumento();
    }
}
