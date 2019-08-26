package it.danieltrosko.shop.service;

import it.danieltrosko.shop.model.Auction;
import it.danieltrosko.shop.model.User;
import it.danieltrosko.shop.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AuctionService {
    @Autowired
    private AuctionRepository auctionRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    public List<Auction> findALl() {
        return auctionRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Auction getById(Long id){
        return auctionRepository.getOne(id);
    }

    @Transactional
    public void createAuction(Auction auction){
        auctionRepository.save(auction);
    }
    @Transactional(readOnly = true)
    public List<Auction> getAllByUserId(Long id){
        return auctionRepository.findAllByUserId(id);
    }

    @Transactional
    public void delete(Long id){
        auctionRepository.deleteById(id);
    }
}
