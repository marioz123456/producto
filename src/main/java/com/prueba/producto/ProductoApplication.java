package com.prueba.producto;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProductoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--------------------------------------------");
		//System.out.println("\t\tEntorno: " + env.getProperty("spring.profiles.active"));
		System.out.println("--------------------------------------------");
		for (int i = 0; i < 5; i++) {
			System.out.println((6 - i - 1) + " ...");
		}
	}

}
