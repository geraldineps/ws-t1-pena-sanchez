package pe.edu.cibertec.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class FileService {



    private static final String FILE_PATH_1 = "compotamiento.txt";
    private static final String FILE_PATH_2 = "lista.txt";
    private static final String FILE_PATH_3 = "notificacion.txt";

    @Async
    public CompletableFuture<String> analizarComportamiento() throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH_1);
            DataOutputStream dataOutputStream = new DataOutputStream(
                    fileOutputStream)){
            dataOutputStream.writeUTF("Analisis de compotamiento");
            dataOutputStream.writeUTF("Gatitos graciosos");
            dataOutputStream.writeUTF("Los cachorros más adorables");
        }
        return CompletableFuture.completedFuture("Analisis de Comportamiento Terminado");
    }

    @Async
    public CompletableFuture<String> generarRecomendaciones() throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH_2);
            DataOutputStream dataOutputStream = new DataOutputStream(
                    fileOutputStream)){
            dataOutputStream.writeUTF("Listado de Recomendaciones");
            dataOutputStream.writeUTF("Las mascotas más graciosas del mundo");
            dataOutputStream.writeUTF("¿Cómo cuidar a tu gatito?");
        }
        return CompletableFuture.completedFuture("Lista de Recomendaciones generada");
    }

    @Async
    public CompletableFuture<String> filtrarContenido() throws IOException, InterruptedException {
        TimeUnit.SECONDS.sleep(7);
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH_3);
            DataOutputStream dataOutputStream = new DataOutputStream(
                    fileOutputStream)){
            dataOutputStream.writeUTF("Filtrado de Contenido");
            dataOutputStream.writeUTF("Mascotas");
            dataOutputStream.writeUTF("Gatos");
        }
        return CompletableFuture.completedFuture("Filtro de contenido terminado");
    }

}
