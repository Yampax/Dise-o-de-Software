import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneradorNumeros {

    private static GeneradorNumeros instancia = null;

    private int ultimoNumero;
    private List<String> historial;

    private GeneradorNumeros() {
        ultimoNumero = 0;
        historial = new ArrayList<>();
    }

    public static synchronized GeneradorNumeros getInstancia() {
        if (instancia == null) {
            instancia = new GeneradorNumeros();
        }
        return instancia;
    }

    public int generarNumero(String terminal) {
        ultimoNumero++;

        historial.add("Número " + ultimoNumero +
                " - Terminal: " + terminal);

        return ultimoNumero;
    }

    public int consultarUltimoNumero() {
        return ultimoNumero;
    }

    public List<String> obtenerHistorial() {
        return Collections.unmodifiableList(
                new ArrayList<>(historial)
        );
    }
}

