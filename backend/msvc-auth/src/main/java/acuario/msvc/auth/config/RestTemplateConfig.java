package acuario.msvc.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

  @Bean
  public RestTemplate restTemplate() {

    HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
    httpRequestFactory.setConnectionRequestTimeout(5000);
    httpRequestFactory.setConnectTimeout(6000);
    // Esto ya se configura en el request
    // httpRequestFactory.setReadTimeout(150000);

    return new RestTemplate(httpRequestFactory);
  }

}