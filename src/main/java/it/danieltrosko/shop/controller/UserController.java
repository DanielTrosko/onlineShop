package it.danieltrosko.shop.controller;

import it.danieltrosko.shop.dto.UserDTO;
import it.danieltrosko.shop.mapper.UserMapper;
import it.danieltrosko.shop.model.User;
import it.danieltrosko.shop.service.AddressService;
import it.danieltrosko.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static it.danieltrosko.shop.mapper.UserMapper.toDTO;

@Controller
public class UserController {

    private UserService userService;
    private AddressService addressService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping(value = "/adduser", method = RequestMethod.GET)
    public String adduser(Model model) {
        model.addAttribute("UserDTO", new UserDTO());
        return "add_user";
    }

    @PostMapping(value = "/user")
    public String createUser(@Valid @ModelAttribute("UserDTO") UserDTO userDTO, Model model) {

        if (userDTO.getId() == null) {
            this.userService.createUser(userDTO);
        } else {
            this.userService.updateUser(userDTO);
        }

        model.addAttribute("users", this.userService.findALl());
        return "showusers";
    }

    @GetMapping(value = "/user")
    public String showUsers(Model model) {
        model.addAttribute("users", this.userService.findALl());
        return "showusers";
    }

    @PostMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam(required = true) Long id, Model model) {
        this.userService.deleteUserById(id);
        model.addAttribute("users", this.userService.findALl());
        return "showusers";
    }

    @PostMapping(value = "/editUser")
    public String editUser(@RequestParam(required = true) Long id, Model model) {
        model.addAttribute("UserDTO", toDTO(userService.getById(id)));

        return "add_user";
    }
//    @PostMapping(value = "/login")
//    public String login(@RequestParam(required = true) String login, String password, Model model){
//        boolean check = userService.login(login,password);
//        if (check){
////            model.addAttribute("check", )
//
//        }
//    }
}