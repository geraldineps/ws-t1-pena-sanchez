package pe.edu.cibertec.ws_t1_pena_sanchez.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.ws_t1_pena_sanchez.service.AtencionService;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
@RestController
public class AtencionController {

    private final AtencionService atencionService;

    @GetMapping("/recomendaciones")
    public String async()
            throws ExecutionException, InterruptedException, IOException {
        CompletableFuture<String> resultado =
                atencionService.atenderRecomendaciones();
        return resultado.get();
    }
}