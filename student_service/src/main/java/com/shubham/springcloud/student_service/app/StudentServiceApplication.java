package com.shubham.springcloud.student_service.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@ComponentScan({"com/shubham/springcloud/student_service/controller", "com/shubham/springcloud/student_service/service"})
@EntityScan("com/shubham/springcloud/student_service/entity")
@EnableJpaRepositories("com/shubham/springcloud/student_service/repository")
@EnableFeignClients("com/shubham/springcloud/student_service/feignclients")
public class StudentServiceApplication {


	@Value("${address.service.url}")
	private String addressServiceURL;

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Bean
	public WebClient webClient(){
		WebClient webClient = WebClient.builder().baseUrl(addressServiceURL).build();

		return webClient;
	}

}
