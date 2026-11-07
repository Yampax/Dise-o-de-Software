public class CreadorArchivo extends CreadorAlerta {

    @Override
    public CanalAlerta crearAlerta() {
        return new AlertaArchivo();
    }
}
