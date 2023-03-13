package br.com.agueme.orquestradorlistacontrato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrquestradorListaContratoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrquestradorListaContratoApplication.class, args);
	}

}
