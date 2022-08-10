package org.ae.cutomer.web;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.ae.cutomer.entities.Customer;
import org.ae.cutomer.request.CustomerRequest;
import org.ae.cutomer.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Log4j2
@RequestMapping("/api/customers")
public class CustomerController {
  private final CustomerService customerService;

  @GetMapping("/{id}")
  public Customer getCustomerById(@PathVariable Integer id) {
    return customerService.getCustomerById(id);
  }

  @PostMapping
  public Customer saveCustomer(@RequestBody CustomerRequest customerRequest) {
    return customerService.saveCustomer(customerRequest);
  }

  @GetMapping
  public List<Customer> getCustomers() {
    return customerService.getCustomers();
  }
}
