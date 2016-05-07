package ru.kpfu.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.Telephones;
import ru.kpfu.itis.repository.TelephonesRepository;


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
