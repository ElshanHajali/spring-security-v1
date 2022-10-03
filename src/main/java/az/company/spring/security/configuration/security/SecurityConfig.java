package az.company.spring.security.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        // Creating details manager
        var userDS = new InMemoryUserDetailsManager();

        // creating user by details
        var usrBill =
                User
                        .withUsername("Tom")
                        .password(
                                passwordEncoder().encode("tpassword")
                        ).authorities("read")
                        .build();

        // adding user to the details manager
        userDS.createUser(usrBill);
        return userDS;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
