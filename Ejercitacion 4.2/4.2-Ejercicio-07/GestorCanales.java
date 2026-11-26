import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestorCanales {

    private final ConcurrentHashMap<String,
            CopyOnWriteArrayList<ObservadorVideo>> suscriptores;

    public GestorCanales() {

        suscriptores = new ConcurrentHashMap<>();
    }

    public void suscribir(String idCanal, ObservadorVideo observador) {

        if (idCanal == null || idCanal.isBlank()
                || observador == null) {

            System.out.println("Suscripción inválida.");
            return;
        }

        suscriptores
            .computeIfAbsent(
                idCanal,
                id -> new CopyOnWriteArrayList<>()
            )
            .addIfAbsent(observador);

        System.out.println(
            "Suscripción realizada al canal: " + idCanal
        );
    }

    public void cancelarSuscripcion(
            String idCanal,
            ObservadorVideo observador) {

        CopyOnWriteArrayList<ObservadorVideo> lista =
                suscriptores.get(idCanal);

        if (lista != null) {

            lista.remove(observador);

            System.out.println(
                "Suscripción cancelada al canal: " + idCanal
            );
        }
    }

    public void publicarVideo(Video video) {

        if (video == null) {
            System.out.println("El video no es válido.");
            return;
        }

        String idCanal = video.getIdCanal();

        System.out.println("\nNuevo video publicado");
        System.out.println("Canal: " + video.getNombreCanal());
        System.out.println("Título: " + video.getTitulo());

        CopyOnWriteArrayList<ObservadorVideo> lista =
                suscriptores.get(idCanal);

        if (lista == null || lista.isEmpty()) {

            System.out.println(
                "No hay usuarios suscritos a este canal."
            );

            return;
        }

        // Notificar solamente a los suscriptores del canal
        for (ObservadorVideo observador : lista) {
            observador.actualizar(video);
        }
    }
}
