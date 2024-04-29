package acuario.fact.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class AuthorizeController {
  
  @GetMapping("/authorized")
  public Map<String, Object> autorized(@RequestParam String code) {
    return Collections.singletonMap("code", code);
  }

}
