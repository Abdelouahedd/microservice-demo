package org.ae.invoice.openFeign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class BearerTokenRequestInterceptor implements RequestInterceptor {
  @Override
  public void apply(RequestTemplate template) {
    log.info("----------- call Interceptor ------");
    final String authorization = HttpHeaders.AUTHORIZATION;
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    if (authentication instanceof JwtAuthenticationToken) {
      Jwt token = ((JwtAuthenticationToken) authentication).getToken();
      String tokenValue = token.getTokenValue();
      template.header(authorization, "Bearer " + tokenValue);
    }
  }
}


