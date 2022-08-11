package org.ae.cutomer.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;


@Data
@Builder
public class CustomerRequest implements Serializable {
  private String firstName;
  private String lastName;
  private String email;
}
