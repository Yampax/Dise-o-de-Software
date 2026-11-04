import java.io.IOException;

public abstract class CreadorExportador {

    // Factory Method
    public abstract ExportadorReporte crearExportador();

    // Método de validación
    protected void validarReporte(ReporteFinanciero reporte) {

        if (reporte == null) {
            throw new IllegalArgumentException(
                "El reporte no puede ser nulo."
            );
        }

        if (reporte.getEncabezado() == null ||
            reporte.getEncabezado().isBlank()) {
            throw new IllegalArgumentException(
                "El encabezado es obligatorio."
            );
        }

        if (reporte.getConcepto() == null ||
            reporte.getConcepto().isBlank()) {
            throw new IllegalArgumentException(
                "El concepto es obligatorio."
            );
        }

        if (!Double.isFinite(reporte.getImporte()) ||
            reporte.getImporte() < 0) {
            throw new IllegalArgumentException(
                "El importe debe ser válido y no negativo."
            );
        }
    }

    // Template Method
    public final void generarReporte(ReporteFinanciero reporte)
            throws IOException {

        validarReporte(reporte);

        ExportadorReporte exportador = crearExportador();

        exportador.exportar(reporte);
    }
}
