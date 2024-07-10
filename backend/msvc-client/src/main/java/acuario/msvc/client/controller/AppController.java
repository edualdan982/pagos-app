package acuario.msvc.client.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import acuario.msvc.client.models.Message;

@RestController
@RequestMapping("/api")
public class AppController {
  private static final Logger log = LoggerFactory.getLogger(AppController.class);

  @GetMapping("/list")
  public List<Message> listar(Authentication authentication) {
    log.info("Endpoint apit-list");
    log.info("User logged: {}", authentication.getName());

    return List.of(new Message("Test list"), new Message(authentication.getAuthorities().toString()));
  }

  @PostMapping("/create")
  public Message create(@RequestBody Message message, Authentication authentication) {
    log.info("Endpoint apit-list");
    log.info("User logged: {}", authentication.getName());
    message.setText(message.getText() + " created: " + authentication.getAuthorities().toString());
    return message;
  }

}
