import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        ReporteFinanciero reporte = new ReporteFinanciero(
            "Reporte Financiero Mensual",
            "Ventas del mes",
            150000
        );

        CreadorExportador creador;

        try {

            // Exportar en PDF
            creador = new CreadorPDF();
            creador.generarReporte(reporte);

            // Exportar en CSV
            creador = new CreadorCSV();
            creador.generarReporte(reporte);

        } catch (IOException | IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}
