package com.dcom.Discovery_Server.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Value("${eureka.username}")
	private String userName;
	
	@Value("${eureka.password}")
	private String password;
	
	@Bean
	InMemoryUserDetailsManager userDetailsManager() {
		
		
		System.err.println("userName= "+userName+" pass="+password);
			
		UserDetails user = User
		            .withUsername(userName)
		            .password(password)
		            .authorities("user")
		            .build();
						
		
		return new InMemoryUserDetailsManager(user);
	}
	
	
	
	@SuppressWarnings({ "removal", "deprecation" })
	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception  {
		System.err.println("filterchain called");


		
		
		httpSecurity.csrf()
		.disable()
		.authorizeHttpRequests()
		.anyRequest().anonymous()
//		.authenticated()
		.and()
		.httpBasic();
		
		return httpSecurity.build();
	}

}
