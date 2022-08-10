package org.ae.cutomer;

import lombok.extern.log4j.Log4j2;
import org.ae.cutomer.entities.Customer;
import org.ae.cutomer.request.CustomerRequest;
import org.ae.cutomer.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Log4j2
public class CustomerApplication {
  public static void main(String[] args) {
    SpringApplication.run(CustomerApplication.class, args);
  }

  @Bean
  CommandLineRunner commandLineRunner(CustomerService customerService) {
    return arguments -> {
      CustomerRequest customer = CustomerRequest.builder()
        .email("abdelouahed@gmail.com")
        .firstName("Ennouri")
        .lastName("Abdelouahed")
        .build();
      CustomerRequest customer1 = CustomerRequest.builder()
        .email("abdeloadoud@gmail.com")
        .firstName("Ennouri")
        .lastName("Abdelouadoud")
        .build();
      Customer customer2 = customerService.saveCustomer(customer);
      Customer customer3 = customerService.saveCustomer(customer1);
      log.info("Saved customer {}", customer2);
      log.info("Saved customer {}", customer3);
    };
  }

}
