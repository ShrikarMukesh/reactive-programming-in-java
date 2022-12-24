package com.rapidapi.controller;

import com.rapidapi.entity.Employee;
import com.rapidapi.service.EmployeeRestClient;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest()
@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {

      @Mock
      EmployeeRestClient employeeRestClient;

      @InjectMocks
      EmployeeController employeeController;

      @Test
      void retriveEmployees(){
          when(employeeRestClient.retriveAllEmployees()).thenReturn(employeeListRes());
          List<Employee> employeeList = employeeController.employeeList();
          assertThat(employeeList.size() >0);
      }

      public static List<Employee> employeeListRes(){
          return Arrays.asList(
                  new Employee(1,22,"James","Rodri","male","Dev"),
                  new Employee(2,23,"Dinesh","Vc","male","Dev")
          );

      }

//    @Autowired
//    private static WebTestClient webTestClient;
//
//    public static void setWebTestClient(WebTestClient webTestClient) {
//        EmployeeControllerTest.webTestClient = webTestClient;
//    }
//    //    @BeforeAll
////    public static void setup() {
////        webTestClient = WebTestClient.bindToServer()
////                .baseUrl("http://localhost:8082")
////                .build();
////    }
//
//    @Test
//    void employeeList() {
//        webTestClient.get()
//                .uri("http://localhost:8081/employees")
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .expectStatus().isOk()
//                .expectHeader().contentType(MediaType.APPLICATION_JSON)
//                .expectBodyList(Employee.class);
//    }
//
//    @Test
//    void getEmployeeById() {
//    }
//
//    @Test
//    void getEmployeeByName() {
//    }
}