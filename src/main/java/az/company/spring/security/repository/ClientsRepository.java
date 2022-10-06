package az.company.spring.security.repository;

import az.company.spring.security.entity.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
public interface ClientsRepository extends JpaRepository<Clients, Long> {

    @Query("""
            Select u from Clients u where u.username = :username
            """)
    Optional<Clients> getClientsByUsername(@Param("username") String username);

}
