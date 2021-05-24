package cl.api.persistence.crud;

import cl.api.persistence.entity.Phone;
import org.springframework.data.repository.CrudRepository;

public interface PhoneCrudRepository extends CrudRepository<Phone, Integer> {
}
