package acuario.msvc.auth.auth.web;

import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizationConsentController {

  private final RegisteredClientRepository registeredClientRepository;
  private final OAuth2AuthorizationConsentService authorizationConsentService;

  public AuthorizationConsentController(RegisteredClientRepository registeredClientRepository,
      OAuth2AuthorizationConsentService authorizationConsentService) {
    this.registeredClientRepository = registeredClientRepository;
    this.authorizationConsentService = authorizationConsentService;
  }

  @GetMapping(value = "/oauth2/consent")
  public String consent(Principal principal, Model model,
      @RequestParam(OAuth2ParameterNames.CLIENT_ID) String clientId,
      @RequestParam(OAuth2ParameterNames.SCOPE) String scope,
      @RequestParam(OAuth2ParameterNames.STATE) String state,
      @RequestParam(name = OAuth2ParameterNames.USER_CODE, required = false) String userCode) {

    // Remove scopes that were already approved
    Set<String> scopesToApprove = new HashSet<>();
    Set<String> previouslyApprovedScopes = new HashSet<>();
    RegisteredClient registeredClient = this.registeredClientRepository.findByClientId(clientId);
    OAuth2AuthorizationConsent currentAuthorizationConsent = this.authorizationConsentService
        .findById(registeredClient.getId(), principal.getName());
    Set<String> authorizedScopes;
    if (currentAuthorizationConsent != null) {
      authorizedScopes = currentAuthorizationConsent.getScopes();
    } else {
      authorizedScopes = Collections.emptySet();
    }
    for (String requestedScope : StringUtils.delimitedListToStringArray(scope, " ")) {
      if (OidcScopes.OPENID.equals(requestedScope)) {
        continue;
      }
      if (authorizedScopes.contains(requestedScope)) {
        previouslyApprovedScopes.add(requestedScope);
      } else {
        scopesToApprove.add(requestedScope);
      }
    }

    model.addAttribute("clientId", clientId);
    model.addAttribute("state", state);
    model.addAttribute("scopes", withDescription(scopesToApprove));
    model.addAttribute("previouslyApprovedScopes", withDescription(previouslyApprovedScopes));
    model.addAttribute("principalName", principal.getName());
    model.addAttribute("userCode", userCode);
    if (StringUtils.hasText(userCode)) {
      model.addAttribute("requestURI", "/oauth2/device_verification");
    } else {
      model.addAttribute("requestURI", "/oauth2/authorize");
    }

    return "consent";
  }

  private static Set<ScopeWithDescription> withDescription(Set<String> scopes) {
    Set<ScopeWithDescription> scopeWithDescriptions = new HashSet<>();
    for (String scope : scopes) {
      scopeWithDescriptions.add(new ScopeWithDescription(scope));

    }
    return scopeWithDescriptions;
  }

  public static class ScopeWithDescription {
    private static final String DEFAULT_DESCRIPTION = "UNKNOWN SCOPE - No podemos proporcionar información sobre este permiso, tenga cuidado al otorgarlo.";
    private static final Map<String, String> scopeDescriptions = new HashMap<>();
    static {
      scopeDescriptions.put(
          OidcScopes.PROFILE,
          "Esta aplicación podrá leer la información de su perfil.");
      scopeDescriptions.put(
          "message.read",
          "Esta aplicación podra leer tus mensajes.");
      scopeDescriptions.put(
          "message.write",
          "Esta aplicación podrá agregar nuevos mensajes. También podrá editar y eliminar mensajes existentes.");
      scopeDescriptions.put(
          "user.read",
          "Esta aplicación podrá leer su información de usuario.");
      scopeDescriptions.put(
          "other.scope",
          "Este es otro ejemplo de ámbito de una descripción de ámbito.");
    }

    public final String scope;
    public final String description;

    ScopeWithDescription(String scope) {
      this.scope = scope;
      this.description = scopeDescriptions.getOrDefault(scope, DEFAULT_DESCRIPTION);
    }
  }

}
