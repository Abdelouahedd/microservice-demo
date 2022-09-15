package org.ae.invoice.openFeign;

import org.ae.invoice.entities.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceClient {
  @GetMapping("api/customers/{id}")
  Customer getCustomerById(@PathVariable("id") Integer id);

  @GetMapping("api/customers")
  List<Customer> getCustomers();
}
