import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final Logger instancia = new Logger();

    private final Path archivo = Path.of("aplicacion.log");

    private final DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private Logger(){
        System.out.println("Sistema de registro inicializado.");
    }

    public static Logger getInstancia() {
        return instancia;
    }

    public synchronized void info(String mensaje) {
        registrar("INFO", mensaje);
    }

    public synchronized void warning(String mensaje) {
        registrar("WARNING", mensaje);
    }

    public synchronized void error(String mensaje) {
        registrar("ERROR", mensaje);
    }

    private void registrar(String nivel, String mensaje) {
        String fecha = LocalDateTime.now().format(formatoFecha);

        String registro = "[" + fecha + "] ["
                + nivel + "] " + mensaje + System.lineSeparator();

        try {
            Files.writeString(
                    archivo,
                    registro,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

            System.out.print(registro);

        } catch (IOException e) {
            System.err.println(
                    "No se pudo guardar el registro: " + e.getMessage()
            );
        }
    }

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstancia();

        logger1.info("La aplicación se inició correctamente.");
        logger1.warning("El espacio disponible es bajo.");
        logger1.error("No se pudo completar una operación.");

        Logger logger2 = Logger.getInstancia();

        System.out.println(
                "¿Es la misma instancia? " + (logger1 == logger2)
        );
    }
}
