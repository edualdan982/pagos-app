package acuario.fact.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/init")
public class InitController {

  @GetMapping("/")
  public String getMethodName(@RequestParam String param) {
    return String.format("Hola, bienvenido usuario");
  }

}
