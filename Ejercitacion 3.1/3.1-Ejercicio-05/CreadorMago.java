public class CreadorMago extends CreadorPersonaje {

    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Mago(nombre);
    }
}
