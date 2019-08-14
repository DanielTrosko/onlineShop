package it.danieltrosko.shop.service;

import it.danieltrosko.shop.dto.UserDTO;
import it.danieltrosko.shop.model.Adress;
import it.danieltrosko.shop.model.User;
import it.danieltrosko.shop.repository.AddressRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AddressService {
    private AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Transactional
    public Adress save(Adress adress) {
        return this.addressRepository.save(adress);
    }

    @Transactional
    public List<Adress> findAll() {
        return this.addressRepository.findAll();
    }

    @Transactional
    public Adress getById(Long id) {
        return this.addressRepository.getOne(id);
    }
    @Transactional
    public void delateById(Long id){
        addressRepository.deleteById(id);
    }
}