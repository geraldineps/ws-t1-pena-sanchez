package pe.edu.cibertec.ws_t1_pena_sanchez.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Service
public class AtencionService {
    private final FileService fileService;

    public CompletableFuture<String> atenderRecomendaciones() throws IOException, InterruptedException {
        CompletableFuture<String> tarea1 = fileService.analizarComportamiento();
        CompletableFuture<String> tarea2 = fileService.generarRecomendaciones();
        CompletableFuture<String> tarea3 = fileService.filtrarContenido();
        return CompletableFuture.allOf(tarea1, tarea2, tarea3)
                .thenApply(result ->{
                    try{
                        String valorTarea1 = tarea1.join();
                        String valorTarea2 = tarea2.join();
                        String valorTarea3 = tarea3.join();
                        return "Resultado de tareas: "+
                                valorTarea1+"-"+
                                valorTarea2+"-"+
                                valorTarea3;
                    }catch (Exception ex){
                        return "Error al combinar los datos "+ex.getMessage();
                    }
                })
                .exceptionally(ex-> "Error al ejecutar tareas " + ex.getMessage());
    }
}

