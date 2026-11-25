public class Main {

    public static void main(String[] args) {

        // Crear el botón
        Boton boton = new Boton();

        // Crear observadores
        VentanaPrincipal ventana = new VentanaPrincipal();
        ContadorClicks contador = new ContadorClicks();

        // Registrar observadores
        boton.suscribir(ventana);
        boton.suscribir(contador);

        // Simular clics
        boton.hacerClick();

        System.out.println("----------------");

        boton.hacerClick();

        System.out.println("----------------");

        boton.hacerClick();

        // Eliminar el contador de clics
        boton.desuscribir(contador);

        System.out.println("----------------");

        // El contador ya no recibirá este evento
        boton.hacerClick();
    }
}
