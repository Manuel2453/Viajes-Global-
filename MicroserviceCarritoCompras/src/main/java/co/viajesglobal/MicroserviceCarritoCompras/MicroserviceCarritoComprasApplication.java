package co.viajesglobal.MicroserviceCarritoCompras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceCarritoComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceCarritoComprasApplication.class, args);
	}

}
