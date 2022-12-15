package com.reactiveprogramming;

import com.reactiveprogramming.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class ReactiveProgrammingTutorialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingTutorialApplication.class, args);
	}

	@Override
	public void run(String[] args) throws IOException {

		//create ObjectMapper instance
		ObjectMapper objectMapper = new ObjectMapper();

		//read JSON file and convert to a customer object
		Customer customer = objectMapper.readValue(new File("/home/shrikar/2023-Dev/reactive-programming-in-java/reactive-programming-tutorial/src/main/resources/customer.json"), Customer.class);

		//print customer details
		System.out.println(customer);
	}

}
