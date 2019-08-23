package it.danieltrosko.shop.controller;

import it.danieltrosko.shop.dto.UserDTO;
import it.danieltrosko.shop.mapper.UserMapper;
import it.danieltrosko.shop.model.User;
import it.danieltrosko.shop.service.AddressService;
import it.danieltrosko.shop.service.AuctionService;
import it.danieltrosko.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static it.danieltrosko.shop.mapper.UserMapper.toDTO;

@Controller
public class UserController {
    protected final Logger log = Logger.getLogger(getClass().getName());
    private UserService userService;
    private AddressService addressService;
    private AuctionService auctionService;


    @Autowired
    public UserController(UserService userService, AuctionService auctionService) {
        this.userService = userService;
        this.auctionService = auctionService;
    }


    //    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String adduser(Model model) {
        model.addAttribute("UserDTO", new UserDTO());
        return "add_user";
    }

    @PostMapping(value = "/user")
    public String createUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO, Model model) throws SQLException {
        if (userDTO.getId() == null) {
            this.userService.createUser(userDTO);
            log.log(Level.INFO, "Create user: " + userDTO.getUsername());
        } else {
            this.userService.updateUser(userDTO);
            log.log(Level.INFO, "Update user: " + userDTO.getUsername());
        }

        model.addAttribute("users", this.userService.findALl());
        return "showusers";
    }

    @GetMapping(value = "/admin/userlist")
    public String showUsers(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        model.addAttribute("username", context.getAuthentication().getName());
        model.addAttribute("users", this.userService.findALl());

        return "showusers";
    }

    @PostMapping(value = "/admin/deleteUser")
    public String deleteUser(@RequestParam(required = true) Long id, Model model) {
        this.userService.deleteUserById(id);
        model.addAttribute("users", this.userService.findALl());
        log.log(Level.INFO, "Delete user id: " + id);
        return "showusers";
    }

    @GetMapping(value = "/user/editUser")
    public String editUser( Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Long id = userService.findByUsername(auth.getName());
        model.addAttribute("UserDTO", toDTO(userService.getById(id)));
        log.log(Level.INFO, "Edit user id: " + id);

        return "/user/edit_user";
    }

    @GetMapping(value = "/login")
    public String index() {
        return "login";
    }

    @GetMapping(value = "/showuser")
    public String showUser(Model model, Long id){
        model.addAttribute("user", this.userService.getById(id));
        model.addAttribute("userAuction", this.auctionService.getAllByUserId(id));
        return "/user/showuser";
    }
}
