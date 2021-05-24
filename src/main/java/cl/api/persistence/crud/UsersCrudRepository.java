package cl.api.persistence.crud;

import cl.api.persistence.entity.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsersCrudRepository extends CrudRepository<Users, Integer> {
    Optional<Users> findByEmail(String email);
}
