package co.viajesglobal.MicroservicePagos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroservicePagosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePagosApplication.class, args);
	}

}
