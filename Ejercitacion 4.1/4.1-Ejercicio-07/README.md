En este ejercicio se desarrolla un portal de noticias que permite a los usuarios suscribirse a diferentes categorías temáticas y recibir avisos cuando se publica un nuevo artículo relacionado con sus intereses.

El patrón Observer se aplica mediante la relación entre el gestor central de publicaciones y los usuarios que reciben las noticias. La interfaz Observador establece el método actualizar(), que deben implementar los usuarios para recibir el objeto de la noticia publicada.

La clase GestorPublicaciones funciona como intermediario del sistema y se encarga de administrar las suscripciones. Para organizar a los usuarios, utiliza un ConcurrentHashMap, donde cada categoría tiene asociada una lista de observadores. De esta manera, un mismo usuario puede estar suscrito a varias categorías y recibir únicamente las publicaciones que correspondan a sus intereses.

Cuando se publica una noticia, se ejecuta el método publicar(), que identifica su categoría y busca la lista de usuarios registrados en ese tópico. Luego recorre esa lista y ejecuta el método actualizar() de cada observador, enviándole el objeto Noticia con su título, contenido y categoría.

La clase Usuario implementa la interfaz Observador y se encarga de recibir la información y mostrar el aviso correspondiente. Además, el sistema permite registrar nuevas suscripciones o cancelarlas durante la ejecución, sin modificar la lógica principal de publicación.

También se utilizan ConcurrentHashMap y CopyOnWriteArrayList para gestionar las suscripciones de manera segura ante modificaciones concurrentes.

<img width="516" height="510" alt="image" src="https://github.com/user-attachments/assets/3c5b3d53-792b-4036-85ad-66cd5106bc7b" />
<img width="487" height="510" alt="image" src="https://github.com/user-attachments/assets/54bb3b2c-dc9c-4300-89be-410ad1c6da88" />

