package org.ae.invoice.request;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class InvoiceRequest {
  private BigDecimal amount;
  private Integer customerId;
}
