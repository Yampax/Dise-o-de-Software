public class CreadorArquero extends CreadorPersonaje {

    @Override
    public Personaje crearPersonaje(String nombre) {
        return new Arquero(nombre);
    }
}
