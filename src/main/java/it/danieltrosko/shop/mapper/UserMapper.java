package it.danieltrosko.shop.mapper;

import it.danieltrosko.shop.dto.UserDTO;
import it.danieltrosko.shop.model.Adress;
import it.danieltrosko.shop.model.Authorities;
import it.danieltrosko.shop.model.User;

public class UserMapper {
    public static User toEntity(UserDTO userDTO) {
        Adress adress = new Adress();
        adress.setId(userDTO.getAddressId());
        adress.setAppartmentNumber(userDTO.getAppartmentNumber());
        adress.setCity(userDTO.getCity());
        adress.setHouseNumber(userDTO.getHouseNumber());
        adress.setStreet(userDTO.getStreet());

        Authorities authorities = new Authorities();
        authorities.setId(userDTO.getAuthoritiesId());
        authorities.setUsernamev(userDTO.getUsername());
        authorities.setAuthority("ROLE_ADMIN");


        User user = new User();
        user.setAuthorities(authorities);
        user.setId(userDTO.getId());
        user.setAdress(adress);
        user.setEmail(userDTO.getEmail());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());
        user.setEnabled(userDTO.isEnabled());
        return user;
    }

    public static UserDTO toDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setName(user.getName());
        userDTO.setSurname(user.getSurname());
        userDTO.setPassword(user.getPassword());
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setEnabled(user.isEnabled());


        Authorities authorities = user.getAuthorities();
        userDTO.setAuthoritiesId(authorities.getId());
        userDTO.setUsernamev(authorities.getUsernamev());
        userDTO.setAuthority(authorities.getAuthority());

        Adress adress = user.getAdress();
        userDTO.setAddressId(adress.getId());
        userDTO.setStreet(adress.getStreet());
        userDTO.setCity(adress.getCity());
        userDTO.setHouseNumber(adress.getHouseNumber());
        userDTO.setAppartmentNumber(adress.getAppartmentNumber());
        return userDTO;
    }
}