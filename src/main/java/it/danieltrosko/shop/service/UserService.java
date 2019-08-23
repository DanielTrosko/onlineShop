package it.danieltrosko.shop.service;

import it.danieltrosko.shop.dto.UserDTO;
import it.danieltrosko.shop.model.User;
import it.danieltrosko.shop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static it.danieltrosko.shop.mapper.UserMapper.toEntity;

@Service
public class UserService {
    private UserRepository userRepository;

    private AddressService addressService;
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserService(UserRepository userRepository, AddressService addressService) {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    @Transactional
    public void createUser(UserDTO userDTO) {
        User user = toEntity(userDTO);
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
        insertWithQuery(user.getUsername());
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

    @Transactional
    public void deleteUserById(Long id) {
        this.userRepository.deleteById(id);
    }


    @Transactional
    public Long findByUsername(String username){
        User user = this.userRepository.findByUsername(username);
        return user.getId();
    }



    @Transactional
    public void insertWithQuery(String username) {
        entityManager.createNativeQuery("INSERT INTO `authorities`(`username`, `authority`) VALUES (?,'ROLE_USER')")
                .setParameter(1, username)
                .executeUpdate();
    }

}
