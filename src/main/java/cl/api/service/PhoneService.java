package cl.api.service;

import cl.api.dto.RegisterDto;
import cl.api.persistence.PhoneRepository;
import cl.api.persistence.entity.Phone;
import cl.api.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> saveAll(Users users, RegisterDto registerDto) {
        return saveAll(Phone.from(users, registerDto));
    }


    public List<Phone> saveAll(List<Phone> phones) {
        return phoneRepository.saveAll(phones);
    }
}
