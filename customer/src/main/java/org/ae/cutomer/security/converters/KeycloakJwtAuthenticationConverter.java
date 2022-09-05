package org.ae.cutomer.security.converters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collection;

/**
 * Converts a JWT into a Spring authentication token (by extracting
 * the username and roles from the claims of the token, delegating
 * to the {@link KeycloakGrantedAuthoritiesConverter})
 */


@Slf4j
public class KeycloakJwtAuthenticationConverter implements Converter<Jwt, AbstractAuthenticationToken> {

  private final Converter<Jwt, Collection<GrantedAuthority>> grantedAuthoritiesConverter;


  public KeycloakJwtAuthenticationConverter(Converter<Jwt, Collection<GrantedAuthority>> grantedAuthoritiesConverter) {
    this.grantedAuthoritiesConverter = grantedAuthoritiesConverter;
  }

  @Override
  public JwtAuthenticationToken convert(Jwt jwt) {
    Collection<GrantedAuthority> authorities = grantedAuthoritiesConverter.convert(jwt);
    String username = getUsernameFrom(jwt);
    return new JwtAuthenticationToken(jwt, authorities, username);
  }

  protected String getUsernameFrom(Jwt jwt) {
    if (Boolean.TRUE.equals(jwt.getClaimAsBoolean("preferred_username"))) {
      return jwt.getClaimAsString("preferred_username");
    }
    return jwt.getSubject();
  }

}
