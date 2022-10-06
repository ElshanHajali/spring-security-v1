package az.company.spring.security.security;

import az.company.spring.security.entity.Authorities;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class GrantedAuthoritiesAdaptor implements GrantedAuthority {
    private final Authorities authority;

    @Override
    public String getAuthority() {
        return authority.getName();
    }
}
