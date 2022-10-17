package az.company.spring.security.filter;

import az.company.spring.security.authentication.CustomAuthentication;
import az.company.spring.security.manager.CustomAuthenticationManager;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationFilter extends OncePerRequestFilter {
    private final CustomAuthenticationManager authenticationManager;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {
        // Creating Authentication object which is not authenticated
        String key = String.valueOf(request.getHeader("key"));

        var customAuthentication =
                new CustomAuthentication(false, key);

        var authentication =
                authenticationManager.authenticate(customAuthentication);

        // If authentication succeed,
        // add to the security context then
        // propagate to the next filter in the chain
        if (authentication.isAuthenticated()) {
            SecurityContextHolder
                    .getContext()
                    .setAuthentication(authentication);

            filterChain.doFilter(request, response);
        }
    }
}
