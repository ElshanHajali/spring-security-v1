package az.company.spring.security.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping
    public String getTest() {
        var user = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            System.out.println(authority.toString());
        }

        return "Test is fine!";
    }
}
