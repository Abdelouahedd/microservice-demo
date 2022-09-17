package org.ae.invoice.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


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
  private LocalDateTime createAt;
  @Transient
  private Customer customer;
}

