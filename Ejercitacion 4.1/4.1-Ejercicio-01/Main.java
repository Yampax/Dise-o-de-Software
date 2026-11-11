public class Main {

    public static void main(String[] args) {

        EstacionMeteorologica estacion =
                new EstacionMeteorologica();

        Pantalla pantalla1 = new Pantalla("Recepción");
        Pantalla pantalla2 = new Pantalla("Administración");
        Pantalla pantalla3 = new Pantalla("Pasillo");

        // Registrar observadores
        estacion.registrar(pantalla1);
        estacion.registrar(pantalla2);
        estacion.registrar(pantalla3);

        // Actualizar temperatura
        System.out.println("Primera actualización:");
        estacion.setTemperatura(25.5);

        // Eliminar una pantalla
        estacion.eliminar(pantalla2);

        System.out.println("\nSegunda actualización:");
        estacion.setTemperatura(28.0);

    }
}
