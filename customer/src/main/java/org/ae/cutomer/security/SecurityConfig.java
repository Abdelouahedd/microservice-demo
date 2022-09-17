package org.ae.cutomer.security;


import lombok.AllArgsConstructor;
import org.ae.cutomer.security.converters.KeycloakJwtAuthenticationConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

  private final KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
      .authorizeHttpRequests(authorize -> authorize
        .mvcMatchers("/actuator/**").permitAll()
        .anyRequest().authenticated()
      )
      .oauth2ResourceServer()
      .jwt()
      .jwtAuthenticationConverter(keycloakJwtAuthenticationConverter);
    return http.build();
  }


}
