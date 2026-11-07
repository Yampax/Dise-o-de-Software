import java.util.HashMap;
import java.util.Map;

public class SelectorFactorias {

    private final Map<TipoFormato, CreadorImportador> creadores;

    public SelectorFactorias() {
        creadores = new HashMap<>();

        creadores.put(TipoFormato.CSV, new CreadorCSV());
        creadores.put(TipoFormato.XML, new CreadorXML());
        creadores.put(TipoFormato.JSON, new CreadorJSON());
    }

    public CreadorImportador obtenerCreador(TipoFormato tipo) {

        CreadorImportador creador = creadores.get(tipo);

        if (creador == null) {
            throw new IllegalArgumentException(
                    "Formato de importación no disponible");
        }

        return creador;
    }
}
