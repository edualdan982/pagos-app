package acuario.pagos.controller;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {

  @GetMapping("/info")
  public String info() {
    return "Esta arriba el servicio msvc-pagos";
  }

  @GetMapping("/authorized")
  public Map<String, Object> autorized(@RequestParam String code) {
    return Collections.singletonMap("code", code);
  }
}
