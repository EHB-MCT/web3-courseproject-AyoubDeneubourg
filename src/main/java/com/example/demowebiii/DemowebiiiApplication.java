package com.example.demowebiii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.List;

@SpringBootApplication
public class DemowebiiiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(DemowebiiiApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemowebiiiApplication.class);
	}

}
