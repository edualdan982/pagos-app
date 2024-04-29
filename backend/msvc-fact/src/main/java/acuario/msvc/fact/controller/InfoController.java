package acuario.msvc.fact.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

  @GetMapping
  public ResponseEntity<Map<String, Object>> infoApp() {
    Map<String, Object> response = new HashMap<>();
    response.put("estado", true);
    response.put("mensaje", "App estado: activo");
    response.put("fecha", new Date());
    return ResponseEntity.ok(response);
  }

}
