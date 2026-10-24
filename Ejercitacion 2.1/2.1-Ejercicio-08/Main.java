public class Main {

    public static void main(String[] args) {

        // Se obtiene la instancia única
        PasarelaPago pasarela = PasarelaPago.getInstancia();

        // Se inyecta mediante el constructor
        ServicioCompra servicio1 =
                new ServicioCompra(pasarela);

        ServicioCompra servicio2 =
                new ServicioCompra(pasarela);

        servicio1.comprar("Ana", 15000);
        servicio2.comprar("Carlos", 25000);

        System.out.println("¿Usan la misma pasarela? "
                + (servicio1.obtenerPasarela()
                == servicio2.obtenerPasarela()));
    }
}
