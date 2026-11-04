public class ExportadorPDF implements ExportadorReporte {

    @Override
    public void exportar(ReporteFinanciero reporte) {

        System.out.println("\n--- REPORTE PDF ---");
        System.out.println(reporte.getEncabezado());
        System.out.println("-------------------------");
        System.out.println("Concepto: " + reporte.getConcepto());
        System.out.println("Importe: $" + reporte.getImporte());
        System.out.println("-------------------------");

        System.out.println("Reporte exportado en formato PDF.");
    }
}
