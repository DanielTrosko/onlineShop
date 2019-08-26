package it.danieltrosko.shop.rest;

import it.danieltrosko.shop.model.Auction;
import it.danieltrosko.shop.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuctionRestController {

    @Autowired
    AuctionService auctionService;

    @RequestMapping(value = "/rest/find", method = RequestMethod.GET)
    public Auction getAuctionById(@RequestParam Long id) {

        try {
            return this.auctionService.getById(id);
        } catch (Exception exc) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Auction not found", exc);
        }

    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @RequestMapping(value = "/rest/addauction", method = RequestMethod.POST)
    public void addAuction(@Valid @RequestBody Auction auction) {
        this.auctionService.createAuction(auction);
    }

    @RequestMapping(value = "/rest/findallauction", method = RequestMethod.GET)
    public List<Auction> findAllAuction() {
        return this.auctionService.findALl();
    }

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/rest/deleteauction", method = RequestMethod.DELETE)
    public void deleteAuctionById(@RequestParam Long id) {
        this.auctionService.delete(id);
    }
}
