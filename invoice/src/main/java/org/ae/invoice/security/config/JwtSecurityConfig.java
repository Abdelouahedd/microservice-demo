package org.ae.invoice.security.config;

import org.ae.invoice.security.converters.KeycloakGrantedAuthoritiesConverter;
import org.ae.invoice.security.converters.KeycloakJwtAuthenticationConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;

@Configuration
public class JwtSecurityConfig {
  @Bean
  Converter<Jwt, Collection<GrantedAuthority>> keycloakGrantedAuthoritiesConverter(GrantedAuthoritiesMapper authoritiesMapper) {
    return new KeycloakGrantedAuthoritiesConverter(authoritiesMapper);
  }

  @Bean
  KeycloakJwtAuthenticationConverter keycloakJwtAuthenticationConverter(Converter<Jwt, Collection<GrantedAuthority>> authoritiesConverter) {
    return new KeycloakJwtAuthenticationConverter(authoritiesConverter);
  }

  @Bean
  GrantedAuthoritiesMapper keycloakAuthoritiesMapper() {
    SimpleAuthorityMapper mapper = new SimpleAuthorityMapper();
    mapper.setConvertToUpperCase(true);
    return mapper;
  }
}
