package it.danieltrosko.shop.controller;

import it.danieltrosko.shop.dto.AuctionDTO;
import it.danieltrosko.shop.model.Auction;
import it.danieltrosko.shop.repository.AuctionRepository;
import it.danieltrosko.shop.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AuctionController {


    private AuctionService auctionService;

    @Autowired
    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }




    @GetMapping(value = "/auctions")
    public String index(Model model) {
        model.addAttribute("auctions", this.auctionService.findALl());
        return "auctions";
    }

    @RequestMapping(value = "/addauction", method = RequestMethod.GET)
    public String createAuction(Model model){
        model.addAttribute("AuctionDTO", new AuctionDTO());
        return "add_auction";
    }
}
