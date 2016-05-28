package dz.labs.services;

import dz.labs.repository.TelephonesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dz.labs.model.Telephones;


@Service
public class TelephoneService {
    @Autowired
    private TelephonesRepository telephonesRepository;

    @Transactional
    public void addTelephone(Telephones telephones) {
        telephonesRepository.add(telephones);
    }

    @Transactional
    public Telephones getTelephoneByString(String telephone) {
        return telephonesRepository.getTelephoneByString(telephone);
    }

}
