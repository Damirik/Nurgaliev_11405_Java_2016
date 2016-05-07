package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.Addresses;
import ru.kpfu.itis.repository.AddressRepository;


@Service
public class AddressesService {
    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void addAddresses(Addresses addresses) {
        addressRepository.add(addresses);
    }

    @Transactional
    public Addresses getAddressByString(String address) {
        return addressRepository.getAddressByString(address);
    }
}
