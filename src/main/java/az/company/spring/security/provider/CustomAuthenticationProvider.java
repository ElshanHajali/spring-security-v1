package az.company.spring.security.provider;

import az.company.spring.security.authentication.CustomAuthentication;
import az.company.spring.security.config.SecurityKeyConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private final SecurityKeyConfig securityKey;

    @Override
    public Authentication authenticate(Authentication authentication
    ) throws AuthenticationException {

       var customAuthentication =
               (CustomAuthentication) authentication;

       String headerKey = customAuthentication.getKey();

       if (securityKey.getKey().equals(headerKey)){
           return new CustomAuthentication(true, null);
       }

       throw new BadCredentialsException("Bad credentials..!");
    }

    // This tells to the authentication manager,
    // which authentication provider should use
    @Override
    public boolean supports(Class<?> authentication) {
        return CustomAuthentication.class.equals(authentication);
    }
}
