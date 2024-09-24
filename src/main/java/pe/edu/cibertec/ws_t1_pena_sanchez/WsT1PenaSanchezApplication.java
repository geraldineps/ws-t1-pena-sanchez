package pe.edu.cibertec.ws_t1_pena_sanchez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class WsT1PenaSanchezApplication {

	public static void main(String[] args) {
		SpringApplication.run(WsT1PenaSanchezApplication.class, args);
	}

}
