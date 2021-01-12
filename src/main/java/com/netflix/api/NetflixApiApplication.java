package com.netflix.api;

import lombok.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NetflixApiApplication {

	@Value("${tmdb.api_key}")
	private  String tmdbApiKey;
	System.out.println(tmdbApiKey);
	public static void main(String[] args) {
		SpringApplication.run(NetflixApiApplication.class, args);
	}
}
