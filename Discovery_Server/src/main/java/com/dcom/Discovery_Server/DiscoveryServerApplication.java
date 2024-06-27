package com.dcom.Discovery_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	public static void main(String[] args) {
		
		System.err.println("Main Is called start!");
		
		SpringApplication.run(DiscoveryServerApplication.class, args);
		
		
		System.err.println("Main Is called end!");
	}

}
