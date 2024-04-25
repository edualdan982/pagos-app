package acuario.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/info")
public class InfoController {

  @Autowired
  private BCryptPasswordEncoder passwordEncoder;

  @GetMapping("/estado")
  public ResponseEntity<Map<String, Object>> info() {
    Map<String, Object> response = Map.of("estado", true, "date", new Date());
    return ResponseEntity.ok(response);
  }

  @GetMapping
  public ResponseEntity<Map<String, Object>> encriptarClave(@RequestParam(required = false) String clave) {
    Map<String, Object> response = Map.of("clave", passwordEncoder.encode(clave));
    return ResponseEntity.ok(response);
  }

  @GetMapping("/clave")
  public ResponseEntity<Map<String, Object>> compararClaves(@RequestParam String claveEncode,
      @RequestParam String clave) {
    Map<String, Object> response = Map.of("resultado", passwordEncoder.matches( clave, claveEncode));
    return ResponseEntity.ok(response);
  }

}
