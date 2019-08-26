package it.danieltrosko.shop.controller;


import it.danieltrosko.shop.model.Auction;
import it.danieltrosko.shop.model.User;

import it.danieltrosko.shop.service.AuctionService;
import it.danieltrosko.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AuctionController {


    private AuctionService auctionService;
    private UserService userService;

    @Autowired
    public AuctionController(AuctionService auctionService, UserService userService) {
        this.auctionService = auctionService;
        this.userService = userService;
    }




    @GetMapping(value = "/auctions")
    public String showAuctions(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("auctions", this.auctionService.findALl());
        return "/auction/auctions";
    }

    @GetMapping(value = "/user/addauctions")
    public String addAuction(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long id = this.userService.findByUsername(auth.getName());
        model.addAttribute("Auction", new Auction());
        return "/auction/add_auction";
    }

    @PostMapping(value = "/auction")
    public String createAuction(Auction auction, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = this.userService.getById(this.userService.findByUsername(auth.getName()));
        auction.setUser(user);
        this.auctionService.createAuction(auction);
        Long id = auction.getUser().getId();
        model.addAttribute("auctions",this.auctionService.getAllByUserId(id));
        return "/auction/myauction";
    }

    @GetMapping(value = "/showauction")
    public String showAuction(Long id, Model model){
        model.addAttribute("auction", this.auctionService.getById(id));
        return "/auction/showauction";
    }

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }

    @GetMapping(value = "/user/myauctions")
    public String showMyAuctions(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long id = this.userService.findByUsername(auth.getName());
        model.addAttribute("auctions", this.auctionService.getAllByUserId(id));
        model.addAttribute("user", auth.getName());
        return "/auction/myauction";
    }

    @GetMapping(value = "/")
    public String index(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName());
        model.addAttribute("auctions", this.auctionService.findALl());
        return "/auction/auctions";
    }
}
