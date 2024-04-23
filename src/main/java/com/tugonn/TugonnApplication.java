package com.tugonn;

import com.tugonn.util.HTTPResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TugonnApplication {

	public static void main(String[] args) {
		SpringApplication.run(TugonnApplication.class, args);
		System.out.println("------------------------------");
		System.out.println("APPLICATION STARTED");
		System.out.println("------------------------------");
	}

	@Bean
	public HTTPResponse httpResponse(){
		return new HTTPResponse();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
