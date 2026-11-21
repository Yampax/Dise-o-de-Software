import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestorEmpleados implements Sujeto {

    private List<Empleado> empleados = new ArrayList<>();

    private final CopyOnWriteArrayList<Auditor> auditores =
            new CopyOnWriteArrayList<>();

    @Override
    public void suscribir(Auditor auditor) {
        if (auditor != null) {
            auditores.addIfAbsent(auditor);
        }
    }

    @Override
    public void desuscribir(Auditor auditor) {
        auditores.remove(auditor);
    }

    @Override
    public void notificar(String mensaje) {
        for (Auditor auditor : auditores) {
            auditor.actualizar(mensaje);
        }
    }

    // Alta de empleado
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);

        notificar("ALTA: Se registró el empleado "
                + empleado.getNombre());
    }

    // Baja de empleado
    public void eliminarEmpleado(int id) {
        Empleado empleado = buscarEmpleado(id);

        if (empleado != null) {
            empleados.remove(empleado);

            notificar("BAJA: Se eliminó el empleado "
                    + empleado.getNombre());
        }
    }

    // Modificación de empleado
    public void modificarEmpleado(int id, String nuevoNombre,
                                  String nuevoPuesto) {

        Empleado empleado = buscarEmpleado(id);

        if (empleado != null) {
            empleado.setNombre(nuevoNombre);
            empleado.setPuesto(nuevoPuesto);

            notificar("MODIFICACIÓN: Se actualizaron los datos del empleado "
                    + nuevoNombre + ". Nuevo puesto: " + nuevoPuesto);
        }
    }

    private Empleado buscarEmpleado(int id) {
        for (Empleado empleado : empleados) {
            if (empleado.getId() == id) {
                return empleado;
            }
        }

        return null;
    }
}
