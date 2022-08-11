package org.ae.cutomer.dto;

import org.ae.cutomer.entities.Customer;
import org.ae.cutomer.request.CustomerRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
  Customer toCustomer(CustomerRequest customerRequest);
}
