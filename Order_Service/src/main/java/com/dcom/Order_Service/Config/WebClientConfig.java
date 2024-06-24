package com.dcom.Order_Service.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

//	@Bean
//	WebClient webClient() {
//
//		return WebClient.builder().build();
//	}
	
	
	// loadbalance not accept localhost:8083 it required service name!
	@Bean
	@LoadBalanced		
	WebClient.Builder webClientBuilder() {
		
		return WebClient.builder();
	}
}
