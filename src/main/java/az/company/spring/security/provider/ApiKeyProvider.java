package az.company.spring.security.provider;

import az.company.spring.security.authentication.ApiKeyAuthentication;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import static lombok.AccessLevel.PUBLIC;

@RequiredArgsConstructor
public class ApiKeyProvider implements AuthenticationProvider {

    @Getter(PUBLIC)
    private final String key;

    @Override
    public Authentication authenticate(
            Authentication authentication) throws AuthenticationException {
        var keyAuth = (ApiKeyAuthentication) authentication;

        if (key.equals(keyAuth.getKey())) {
            keyAuth.setAuthenticated(true);
            return keyAuth;
        }

        throw new BadCredentialsException("Bad credentials..!");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiKeyAuthentication.class.equals(authentication);
    }
}
