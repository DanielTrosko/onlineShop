package it.danieltrosko.shop.repository;

import it.danieltrosko.shop.model.Auction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
}
