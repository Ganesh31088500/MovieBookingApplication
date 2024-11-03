package com.ganesh.MovieBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MovieBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingApplication.class, args);
	}

}