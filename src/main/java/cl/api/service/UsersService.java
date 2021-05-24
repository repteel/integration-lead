package cl.api.service;

import cl.api.dto.RegisterDto;
import cl.api.persistence.UsersRepository;
import cl.api.persistence.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;


    public Optional<Users> getEmail(String e){
        return usersRepository.validarEmail(e);
    }
    public Users save(RegisterDto registerDto)  {
        return save(Users.from(registerDto, registerDto.getPassword(), registerDto.getToken()));
    }

    private Users save(Users users) {
        return usersRepository.save(users);
    }
    private List<Users> getAll(){
        return usersRepository.getAll();
    }


}
