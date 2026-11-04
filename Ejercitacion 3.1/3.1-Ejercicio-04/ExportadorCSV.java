public class ExportadorCSV implements ExportadorReporte {

    @Override
    public void exportar(ReporteFinanciero reporte) {

        System.out.println("\n--- REPORTE CSV ---");
        System.out.println("Encabezado,Concepto,Importe");
        System.out.println(
            reporte.getEncabezado() + "," +
            reporte.getConcepto() + "," +
            reporte.getImporte()
        );

        System.out.println("Reporte exportado en formato CSV.");
    }
}
