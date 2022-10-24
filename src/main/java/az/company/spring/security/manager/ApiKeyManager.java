package az.company.spring.security.manager;

import az.company.spring.security.provider.ApiKeyProvider;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import static lombok.AccessLevel.PUBLIC;

@RequiredArgsConstructor
public class ApiKeyManager implements AuthenticationManager {

    @Getter(PUBLIC)
    private final String key;

    @Override
    public Authentication authenticate(
            Authentication authentication) throws AuthenticationException {
        var keyProvider = new ApiKeyProvider(key);

        if (keyProvider.supports(authentication.getClass())) {
            return keyProvider.authenticate(authentication);
        }

        else return authentication;
    }
}
