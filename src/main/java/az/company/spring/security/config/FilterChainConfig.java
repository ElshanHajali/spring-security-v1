package az.company.spring.security.config;

import az.company.spring.security.filter.CustomAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class FilterChainConfig {
    private final CustomAuthenticationFilter authenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .addFilterAt(
                        authenticationFilter,
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests().anyRequest().authenticated() // TODO
                .and().build();
    }
}
