package it.danieltrosko.shop.controller;

import it.danieltrosko.shop.repository.AuctionRepository;
import it.danieltrosko.shop.service.AuctionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuctionController {

   private AuctionService auctionService;
    @GetMapping
    public String index(Model model) {
        model.addAttribute("auctions", this.auctionService.findALl());
        return "index";
    }
}
