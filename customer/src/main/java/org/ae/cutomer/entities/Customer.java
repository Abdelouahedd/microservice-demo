package org.ae.cutomer.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

  @Id
  @SequenceGenerator(
    name = "customer_id_sequence",
    sequenceName = "customer_id_sequence"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "customer_id_sequence"
  )
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;

}
