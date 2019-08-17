package it.danieltrosko.shop.service;

import it.danieltrosko.shop.model.Auction;
import it.danieltrosko.shop.model.User;
import it.danieltrosko.shop.repository.AuctionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuctionService {

    private AuctionRepository auctionRepository;

    @Transactional(readOnly = true)
    public List<Auction> findALl() {
        return auctionRepository.findAll();
    }
}
