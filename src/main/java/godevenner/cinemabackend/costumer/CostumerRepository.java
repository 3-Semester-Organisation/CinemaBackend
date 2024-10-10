package godevenner.cinemabackend.costumer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CostumerRepository extends JpaRepository<Costumer, Long> {
    Optional<Costumer> findByEmail(String email);
}
