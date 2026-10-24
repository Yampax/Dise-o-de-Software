
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static Logger instancia = null;

    private final String archivo = "aplicacion.log";

    private Logger() {
        System.out.println("Logger inicializado.");
    }

    public static synchronized Logger getInstancia() {
        if (instancia == null) {
            instancia = new Logger();
        }
        return instancia;
    }

    private synchronized void registrar(String nivel, String mensaje) {
        if (mensaje == null || mensaje.isBlank()) {
            System.out.println("El mensaje no puede estar vacío.");
            return;
        }

        String fecha = LocalDateTime.now().format(
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
        );

        String registro = "[" + fecha + "] [" + nivel + "] " + mensaje;

        System.out.println(registro);

        try (PrintWriter escritor = new PrintWriter(
                new FileWriter(archivo, true))) {

            escritor.println(registro);

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: "
                    + e.getMessage());
        }
    }

    public void info(String mensaje) {
        registrar("INFO", mensaje);
    }

    public void warning(String mensaje) {
        registrar("WARNING", mensaje);
    }

    public void error(String mensaje) {
        registrar("ERROR", mensaje);
    }

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstancia();

        logger1.info("Aplicación iniciada.");
        logger1.warning("El espacio de almacenamiento es bajo.");
        logger1.error("No se pudo procesar la solicitud.");

        Logger logger2 = Logger.getInstancia();

        System.out.println("¿Es la misma instancia? "
                + (logger1 == logger2));
    }
}
