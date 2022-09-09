package org.ae.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class InvoiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(InvoiceApplication.class, args);
  }
}
