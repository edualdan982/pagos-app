package acuario.msvc.client.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authorized")
public class AuthorizedController {

  @GetMapping
  public Map<String, Object> authorized(@RequestParam String code, @RequestParam String state) {
    Map<String, Object> response = new HashMap<>();
    response.put("code", code);
    response.put("state", state);
    return response;
  }
}
