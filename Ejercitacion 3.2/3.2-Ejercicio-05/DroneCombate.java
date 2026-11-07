public class DroneCombate implements Enemigo {

    private final int salud = 80;
    private final int danio = 40;
    private final int velocidad = 12;
    private final String comportamiento = "Patrullar y atacar a distancia";

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
        System.out.println("=== DRONE DE COMBATE ===");
        System.out.println("Salud: " + salud);
        System.out.println("Daño: " + danio);
        System.out.println("Velocidad: " + velocidad);
        System.out.println("Táctica: " + comportamiento);
    }
}
