package org.ae.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class GatewayServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(GatewayServiceApplication.class, args);
  }

  @RestController
  class FallbackController {

    @GetMapping("/books-fallback")
    Flux<Void> getBooksFallback() {
      return Flux.empty();
    }

  }
}
