package acuario.jwtlogin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  private static final Logger log = LoggerFactory.getLogger(HelloController.class);

  @GetMapping("/")
  public String hello(Authentication authentication) {
    authentication.getAuthorities().forEach(authority -> log.info("Authority: {}", authority));
    return String.format("Hello, %s !", authentication.getName());
  }

}
