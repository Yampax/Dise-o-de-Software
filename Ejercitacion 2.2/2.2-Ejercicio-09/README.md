Se utiliza el patrón Singleton para garantizar que todos los hilos accedan a una única instancia del gestor de impresión. El método getInstancia() está sincronizado para evitar la creación de instancias duplicadas durante la concurrencia. Además, se sincronizan las operaciones sobre la cola y el historial para proteger los datos compartidos. Los documentos se almacenan en una cola FIFO, que permite procesarlos en el orden en que fueron incorporados. También se controlan los identificadores para evitar trabajos duplicados y se conserva un historial de los documentos procesados para generar el informe final.

<img width="282" height="548" alt="image" src="https://github.com/user-attachments/assets/f8f4f8cb-2208-4841-ab7e-b2992f5ae117" />

<img width="684" height="537" alt="image" src="https://github.com/user-attachments/assets/1d1d31c4-0078-4755-9e8d-859b07105334" />

<img width="697" height="532" alt="image" src="https://github.com/user-attachments/assets/0a21d307-2e7c-43c9-bbff-0c35fad602b4" />

<img width="590" height="528" alt="image" src="https://github.com/user-attachments/assets/3e8a49e9-e6e3-41d4-aefd-768e0bf0c059" />

<img width="576" height="467" alt="image" src="https://github.com/user-attachments/assets/73ffe0d4-bfb1-4093-9bc8-862fed6c7a0a" />
