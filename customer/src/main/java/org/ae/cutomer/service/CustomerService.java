package org.ae.cutomer.service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.ae.cutomer.dto.CustomerMapper;
import org.ae.cutomer.entities.Customer;
import org.ae.cutomer.repository.CustomerRepository;
import org.ae.cutomer.request.CustomerRequest;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@AllArgsConstructor
@Log4j2
public class CustomerService {
  private final CustomerRepository customerRepository;
  private final CustomerMapper customerMapper;

  public Customer getCustomerById(Integer id) {
    return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Customer with id = %d not found", id)));
  }

  public Customer saveCustomer(CustomerRequest customerRequest) {
    Customer customer = customerMapper.toCustomer(customerRequest);
    return customerRepository.saveAndFlush(customer);
  }

  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }
}
