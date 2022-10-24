package az.company.spring.security.filter;

import az.company.spring.security.authentication.ApiKeyAuthentication;
import az.company.spring.security.manager.ApiKeyManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static javax.servlet.http.HttpServletResponse.SC_UNAUTHORIZED;

@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    @Getter(AccessLevel.PUBLIC)
    private final String key;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        var apiKeyManager = new ApiKeyManager(key);

        String headerKey = request.getHeader("x-api-key");
        var apiKeyAuthentication =
                new ApiKeyAuthentication(headerKey);

        if ("null".equals(headerKey) || headerKey == null) {
            filterChain.doFilter(request, response);
        }

        try {
            var authentication =
                    apiKeyManager.authenticate(apiKeyAuthentication);

            if (authentication.isAuthenticated()) {
                SecurityContextHolder.getContext().setAuthentication(authentication);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(SC_UNAUTHORIZED);
            }
        } catch (AuthenticationException exception) {
            response.setStatus(SC_UNAUTHORIZED);
        }
    }
}
