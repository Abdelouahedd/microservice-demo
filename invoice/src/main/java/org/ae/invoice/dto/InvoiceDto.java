package org.ae.invoice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.ae.cutomer.entities.Customer;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class InvoiceDto {
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
  private LocalDate createAt;
  private BigDecimal amount;
  private Customer customer;
}
