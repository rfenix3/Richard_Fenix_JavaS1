package com.company.richardfenixserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RichardFenixServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(RichardFenixServiceRegistryApplication.class, args);
	}

}
