public class SoldadoRaso implements Enemigo {

    private final int salud = 150;
    private final int danio = 25;
    private final int velocidad = 5;
    private final String comportamiento = "Avanzar y atacar";

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public int getDanio() {
        return danio;
    }

    @Override
    public int getVelocidad() {
        return velocidad;
    }

    @Override
    public String getComportamiento() {
        return comportamiento;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== SOLDADO RASO ===");
        System.out.println("Salud: " + salud);
        System.out.println("Daño: " + danio);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Táctica: " + comportamiento);
    }
}
