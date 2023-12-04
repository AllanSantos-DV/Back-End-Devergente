package br.com.devergente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "br.com.devergente")
public class DeVerGenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeVerGenteApplication.class, args);
	}

}
