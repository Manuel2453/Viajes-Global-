package co.viajesglobal.MicroserviceReservas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceReservasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceReservasApplication.class, args);
	}

}
