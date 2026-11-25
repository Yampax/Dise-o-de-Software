public class VentanaPrincipal implements ObservadorClick {

    @Override
    public void alHacerClick() {

        System.out.println(
                "Ventana principal: ejecutando acción del botón."
        );
    }
}
