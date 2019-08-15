package it.danieltrosko.shop;

import it.danieltrosko.shop.dto.UserDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        String encoded=new BCryptPasswordEncoder().encode("haselko");
        System.out.println(encoded);
        SpringApplication.run(ShopApplication.class, args);
    }

}
