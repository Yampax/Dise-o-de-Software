import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class GestorPublicaciones {

    private final ConcurrentHashMap<String, CopyOnWriteArrayList<Observador>>
            suscriptores = new ConcurrentHashMap<>();

    public void suscribir(String categoria, Observador observador) {
        if (categoria != null && observador != null) {
            suscriptores
                    .computeIfAbsent(
                            categoria.toLowerCase().trim(),
                            k -> new CopyOnWriteArrayList<>()
                    )
                    .addIfAbsent(observador);
        }
    }

    public void cancelarSuscripcion(String categoria, Observador observador) {
        if (categoria == null || observador == null) {
            return;
        }

        CopyOnWriteArrayList<Observador> lista =
                suscriptores.get(categoria.toLowerCase().trim());

        if (lista != null) {
            lista.remove(observador);
        }
    }

    public void publicar(Noticia noticia) {
        if (noticia == null || noticia.getCategoria() == null) {
            return;
        }

        String categoria = noticia.getCategoria().toLowerCase().trim();

        CopyOnWriteArrayList<Observador> lista =
                suscriptores.get(categoria);

        System.out.println("\nNueva noticia publicada: " + noticia.getTitulo());
        System.out.println("Categoría: " + noticia.getCategoria());

        if (lista != null) {
            for (Observador observador : lista) {
                observador.actualizar(noticia);
            }
        } else {
            System.out.println("No hay usuarios suscritos a esta categoría.");
        }
    }
}
