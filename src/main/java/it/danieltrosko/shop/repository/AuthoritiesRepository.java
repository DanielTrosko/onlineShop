package it.danieltrosko.shop.repository;

import it.danieltrosko.shop.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Long> {
}
