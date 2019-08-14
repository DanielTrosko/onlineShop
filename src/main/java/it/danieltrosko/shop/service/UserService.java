package it.danieltrosko.shop.service;

import it.danieltrosko.shop.dto.UserDTO;
import it.danieltrosko.shop.model.User;
import it.danieltrosko.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static it.danieltrosko.shop.mapper.UserMapper.toEntity;

@Service
public class UserService {
    private UserRepository userRepository;

    private AddressService addressService;

    @Autowired
    public UserService(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    @Transactional(readOnly = false)
    public void createUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        addressService.save(user.getAdress());
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public List<User> findALl() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Transactional
    public void updateUser(UserDTO userDTO) {
        userRepository.save(toEntity(userDTO));
    }

    @Transactional(readOnly = false)
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }

//    @Transactional(readOnly = true)
//    public boolean login(String login, String password) {
//        User user = userRepository.findByUsername(login);
//        return user.getUsername().equals(login) && user.getPassword().equals(password);
//    }

}
