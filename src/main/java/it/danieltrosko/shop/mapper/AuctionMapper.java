package it.danieltrosko.shop.mapper;

import it.danieltrosko.shop.dto.AuctionDTO;
import it.danieltrosko.shop.model.Auction;
import it.danieltrosko.shop.model.User;

public class AuctionMapper {
    public static Auction toEntity(AuctionDTO auctionDTO) {
        User user = new User();
        user.setId(auctionDTO.getUserId());


        Auction auction = new Auction();
        auction.setId(auctionDTO.getId());
        auction.setMark(auctionDTO.getMark());
        auction.setModel(auctionDTO.getModel());
        auction.setYear(auctionDTO.getYear());
        auction.setPrice(auctionDTO.getPrice());
        auction.setUser(user);
        return auction;
    }

    public static AuctionDTO toDTO(Auction auction) {
        AuctionDTO auctionDTO = new AuctionDTO();
        auctionDTO.setId(auction.getId());
        auctionDTO.setMark(auction.getMark());
        auctionDTO.setModel(auction.getModel());
        auctionDTO.setYear(auction.getYear());
        auctionDTO.setPrice(auction.getPrice());

        User user = auction.getUser();
        auctionDTO.setUserId(user.getId());
        return auctionDTO;
    }
}
