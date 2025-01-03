package com.sistemas.karnaval;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class KarnavalMicroserviceDevolucionApplication {

	public static void main(String[] args) {
		SpringApplication.run(KarnavalMicroserviceDevolucionApplication.class, args);
	}

}
