public class CreadorConsola extends CreadorAlerta {

    @Override
    public CanalAlerta crearAlerta() {
        return new AlertaConsola();
    }
}
