La clase PasarelaPago implementa Singleton mediante un atributo estático inicialmente en null, un constructor privado y el método getInstancia(), que crea una única instancia cuando se solicita por primera vez.

La clase ServicioCompra recibe la pasarela mediante su constructor, en lugar de acceder a ella mediante llamadas estáticas dentro de su lógica. Esto aplica la inyección de dependencias y reduce el acoplamiento entre las clases, facilitando las pruebas y el mantenimiento del código.

Por último, Main se encarga de obtener la instancia única e inyectarla en los servicios que la necesitan. De esta manera, se centraliza la creación de la dependencia y se evita que las clases consumidoras creen sus propias pasarelas.

<img width="340" height="338" alt="image" src="https://github.com/user-attachments/assets/3c15a1b2-b01c-48bb-bc53-0c84bb23167c" />
