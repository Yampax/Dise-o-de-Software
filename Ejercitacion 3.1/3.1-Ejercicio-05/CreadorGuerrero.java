public class CreadorGuerrero extends CreadorPersonaje {

    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Guerrero(nombre);
    }
}
