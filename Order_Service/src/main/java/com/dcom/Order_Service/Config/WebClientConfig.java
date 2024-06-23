package com.dcom.Order_Service.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	@Bean
	WebClient webClient() {

		System.err.println("Heeeeeeeeeeeeeeeeeeeeee");
		return WebClient.builder().build();
	}
}
