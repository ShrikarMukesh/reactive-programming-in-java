package com.reactiveprogramming;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.reactiveprogramming.entity.Address;
import com.reactiveprogramming.entity.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class ReactiveProgrammingTutorialApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingTutorialApplication.class, args);
	}

//	@Override
//	public void run(String[] args) throws IOException {
//
//		//create ObjectMapper instance
//		ObjectMapper objectMapper = new ObjectMapper();
//
//		//read JSON file and convert to a customer object
//		Customer customer = objectMapper.readValue(new File("/home/shrikar/2023-Dev/reactive-programming-in-java/reactive-programming-tutorial/src/main/resources/customer.json"), Customer.class);
//
//		//print customer details
//		System.out.println(customer);
//	}
  @Override
  public void run(String[] args) throws IOException {

	//create ObjectMapper instance
	ObjectMapper objectMapper = new ObjectMapper();

	//read JSON file and convert to a customer object
	Customer customer = objectMapper.readValue(new File("customer.json"), Customer.class);

	//print customer details
	System.out.println(customer);

	//create a customer object
	Customer customerObj = new Customer();
	customerObj.setId(567L);
	customerObj.setName("Maria Kovosi");
	customerObj.setEmail("maria@example.com");
	customerObj.setPhone("+12 785 4895 321");
	customerObj.setAge(29);
	customerObj.setProjects(new String[]{"Path Finder App", "Push Notifications"});

	Address address = new Address();
	address.setStreet("Karchstr.");
	address.setCity("Hanover");
	address.setZipcode(66525);
	address.setCountry("Germany");
	customerObj.setAddress(address);

	List<String> paymentMethods = new ArrayList<>();
	paymentMethods.add("PayPal");
	paymentMethods.add("SOFORT");
	customerObj.setPaymentMethods(paymentMethods);

	Map<String, Object> info = new HashMap<>();
	info.put("gender", "female");
	info.put("married", "No");
	info.put("income", "120,000 EURO");
	info.put("source", "Google Search");
	customerObj.setProfileInfo(info);

	//configure objectMapper for pretty input
	objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

	//write customerObj object to customer2.json file
	objectMapper.writeValue(new File("customer2.json"), customerObj);
  }

}
