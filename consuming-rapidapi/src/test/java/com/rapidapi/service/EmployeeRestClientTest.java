package com.rapidapi.service;

import com.rapidapi.entity.Employee;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EmployeeRestClientTest {

    @Autowired
    private WebTestClient webTestClient;

   // private EmployeeRestClient employeeRestClient;

    @Test
    @Order(1)
    void retriveAllEmployees() {
        webTestClient.get()
                .uri("/employees")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON)
                .expectBodyList(Employee.class);
    }

    @Test
    void retriveEmployeeByID() {
    }

    @Test
    void retriveEmployeeByName() {
    }

    @Test
    void addNewEmployee() {
    }

    @Test
    void updateEmployee() {
    }
}