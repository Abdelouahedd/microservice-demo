package org.ae.invoice.entities;


import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;
}
