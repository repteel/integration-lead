package cl.api.persistence;

import cl.api.persistence.crud.UsersCrudRepository;
import cl.api.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository {
    @Autowired
    private UsersCrudRepository usersCrudRepository;

    public List<Users> getAll() {
        return (List<Users>) usersCrudRepository.findAll();
    }

     public Optional<Users> validarEmail(String email){
         return usersCrudRepository.findByEmail(email);
     }
     public Users save(Users insert) {
        return usersCrudRepository.save(insert);
    }

    /*
    public Optional<Users> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Users save(Users users) {
        return productoCrudRepository.save(users);
    }

    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
     */
}
