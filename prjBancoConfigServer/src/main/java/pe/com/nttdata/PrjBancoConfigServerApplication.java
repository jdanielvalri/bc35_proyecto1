package pe.com.nttdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class PrjBancoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrjBancoConfigServerApplication.class, args);
	}

}
