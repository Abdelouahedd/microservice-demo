package org.ae.invoice.entities;

import lombok.*;
import org.ae.cutomer.entities.Customer;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
  @Id
  @SequenceGenerator(
    name = "invoice_id_sequence",
    sequenceName = "invoice_id_sequence"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "invoice_id_sequence"
  )
  private Integer id;
  private BigDecimal amount;
  private Integer customerId;
  @Transient
  private Customer customer;
}

