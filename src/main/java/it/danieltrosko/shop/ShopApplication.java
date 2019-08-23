package it.danieltrosko.shop;

import it.danieltrosko.shop.dto.UserDTO;
import it.danieltrosko.shop.model.Auction;
import it.danieltrosko.shop.service.AuctionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class ShopApplication {
    public static void main(String[] args) {

    String haelko = "haselko";
    haelko = new BCryptPasswordEncoder().encode(haelko);
        System.out.println(haelko);

        SpringApplication.run(ShopApplication.class, args);
    }

}
