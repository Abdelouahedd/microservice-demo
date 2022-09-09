package org.ae.invoice.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRequest {
  private BigDecimal amount;
  private Integer customerId;
}
