package com.filter.Filters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.filter.Filters.filter.LoginRequiredFilter;

@SpringBootApplication
public class FiltersApplication {

	public static void main(String[] args) {
		SpringApplication.run(FiltersApplication.class, args);
	}

	@Bean
	public LoginRequiredFilter getLoginRequiredFilter(){
		return new LoginRequiredFilter();
	}
}
