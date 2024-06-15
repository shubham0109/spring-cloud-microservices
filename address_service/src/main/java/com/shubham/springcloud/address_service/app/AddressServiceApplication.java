package com.shubham.springcloud.address_service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com/shubham/springcloud/address_service/controller", "com/shubham/springcloud/address_service/service"})
@EntityScan("com/shubham/springcloud/address_service/entity")
@EnableJpaRepositories("com/shubham/springcloud/address_service/repository")
public class AddressServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressServiceApplication.class, args);
	}

}
