Implemente el patrón Factory Method para generar interfaces gráficas adaptadas a diferentes modos de pantalla.

Creé la interfaz `ComponenteUI`, que establece un contrato común de renderizado para los componentes visuales. Luego desarrollé las clases `Boton` y `Etiqueta`, que representan los elementos gráficos y contienen sus respectivas dimensiones.

Implementé la interfaz `InterfazGrafica`, que agrupa los componentes visuales y define las operaciones de renderizado e interacción.

Desarrollé las clases `InterfazEscritorio` e `InterfazMovil`, que crean conjuntos de componentes con dimensiones específicas para cada resolución. De esta manera, cada interfaz mantiene la coherencia visual entre sus elementos.

También implementé la clase abstracta `CreadorInterfaz`, que declara el método de fábrica `crearInterfaz()`, y sus creadores concretos, encargados de generar cada tipo de interfaz.

Finalmente, creé `FabricaInterfaz` para seleccionar el creador correspondiente según el modo de pantalla solicitado. En `Main` solamente indico el tipo de interfaz que necesito, sin crear directamente los componentes concretos.

Considero que esta solución permite mantener un contrato común de renderizado, organizar la creación de componentes compatibles y facilitar la incorporación de nuevos modos de pantalla.

<img width="351" height="269" alt="image" src="https://github.com/user-attachments/assets/8670b476-8bb7-4a91-ae3e-f26f2e78d8e5" />
