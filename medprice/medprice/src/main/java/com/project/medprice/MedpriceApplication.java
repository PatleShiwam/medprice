package com.project.medprice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MedpriceApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(MedpriceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Medprice app started...");

	}

}
