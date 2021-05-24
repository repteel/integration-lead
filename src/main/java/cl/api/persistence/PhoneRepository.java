package cl.api.persistence;

import cl.api.persistence.crud.PhoneCrudRepository;
import cl.api.persistence.entity.Phone;
import cl.api.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PhoneRepository {
    @Autowired
    private PhoneCrudRepository phoneCrudRepository;

    public List<Phone> getAll() {
        return (List<Phone>) phoneCrudRepository.findAll();
    }
    public List<Phone> saveAll(List<Phone> phones){
        return (List<Phone>) phoneCrudRepository.saveAll(phones);
    }
}
