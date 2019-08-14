package it.danieltrosko.shop.repository;

import it.danieltrosko.shop.model.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Adress, Long> {
}
