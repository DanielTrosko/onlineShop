package it.danieltrosko.shop.repository;

import it.danieltrosko.shop.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuctionRepository extends JpaRepository<Auction, Long> {

    List<Auction> findAllByUserId(Long id);
}
