package it.danieltrosko.shop.repository;

import it.danieltrosko.shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
