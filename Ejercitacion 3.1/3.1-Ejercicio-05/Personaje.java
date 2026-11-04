public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected String arma;

    public Personaje(String nombre, int vida,
                     int ataque, int defensa, String arma) {

        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.arma = arma;
    }

    public void mostrarEstadisticas() {

        System.out.println("\nPersonaje: " + nombre);
        System.out.println("Vida: " + vida);
        System.out.println("Ataque: " + ataque);
        System.out.println("Defensa: " + defensa);
        System.out.println("Arma inicial: " + arma);
    }
}
