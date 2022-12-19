package com.rapidapi;

import com.rapidapi.controller.EmployeeController;
import com.rapidapi.entity.Employee;
import com.rapidapi.service.EmployeeRestClient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebFluxTest(EmployeeController.class)
class ConsumingRapidapiApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@MockBean
	private EmployeeRestClient service;

	@Test
	public void getProductsTest(){
		List<Employee> employeeList = Arrays.asList(new Employee(102,23,"Anirudh","Kondala","male","Lead Engineer"),
				new Employee(103,32,"Sonal","Kubra","male","Test Engineer"));

		when(service.retriveAllEmployees()).thenReturn(employeeList);

		List<Employee> responseBody = webTestClient.get().uri("/employees")
				.exchange()
				.expectStatus().isOk()
				.expectBodyList(Employee.class)
						.consumeWith(listEntityExchangeResult -> listEntityExchangeResult.getResponseBody());



	}


}
