package az.company.spring.security.service;

import az.company.spring.security.repository.ClientsRepository;
import az.company.spring.security.security.ClientsDetailsAdaptor;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaClientsDetailsService implements UserDetailsService {
    private final ClientsRepository clientsRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        var clients = clientsRepository.getClientsByUsername(username);

        return clients.map(ClientsDetailsAdaptor::new)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "Username: " + username + " not found!"
                ));
    }
}
