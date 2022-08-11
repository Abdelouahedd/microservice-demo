package org.ae.invoice;

import org.ae.invoice.request.InvoiceRequest;
import org.ae.invoice.service.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class InvoiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(InvoiceApplication.class, args);
  }

  @Bean
  CommandLineRunner run(InvoiceService invoiceService) {
    return (arg) -> {
      InvoiceRequest invoiceRequest = InvoiceRequest.builder().amount(BigDecimal.valueOf(1000L)).customerId(1).build();
      InvoiceRequest invoiceRequest1 = InvoiceRequest.builder().amount(BigDecimal.valueOf(12000L)).customerId(2).build();
      invoiceService.saveInvoice(invoiceRequest);
      invoiceService.saveInvoice(invoiceRequest1);
    };
  }
}
