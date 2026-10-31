public class Terminal {

    private String nombre;
    private GeneradorNumeros generador;

    public Terminal(String nombre) {
        this.nombre = nombre;
        this.generador = GeneradorNumeros.getInstancia();
    }

    public void solicitarNumero() {
        int numero = generador.generarNumero(nombre);

        System.out.println(nombre +
                " recibió el número: " + numero);
    }
}

