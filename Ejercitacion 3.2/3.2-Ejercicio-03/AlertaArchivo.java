import java.io.FileWriter;
import java.io.IOException;

public class AlertaArchivo implements CanalAlerta {

    @Override
    public void enviarAlerta(String mensaje) {

        try (FileWriter archivo = new FileWriter("alertas.log", true)) {

            archivo.write("[ALERTA] " + mensaje + System.lineSeparator());

            System.out.println("Alerta guardada en el archivo alertas.log.");

        } catch (IOException e) {
            System.out.println("Error al guardar la alerta: " + e.getMessage());
        }
    }
}
