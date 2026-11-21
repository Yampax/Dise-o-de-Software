import java.io.FileWriter;
import java.io.IOException;

public class AuditorArchivo implements Auditor {

    @Override
    public void actualizar(String mensaje) {

        try (FileWriter archivo =
                     new FileWriter("auditoria.txt", true)) {

            archivo.write(mensaje + System.lineSeparator());

        } catch (IOException e) {
            System.out.println("Error al guardar la auditoría: "
                    + e.getMessage());
        }
    }
}
