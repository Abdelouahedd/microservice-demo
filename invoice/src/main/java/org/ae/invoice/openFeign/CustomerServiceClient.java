package org.ae.invoice.openFeign;

import org.ae.cutomer.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceClient {
  @GetMapping("/api/customers/{id}")
  Customer getCustomerById(Integer id);
  @GetMapping("/api/customers")
  List<Customer> getCustomers();
}
