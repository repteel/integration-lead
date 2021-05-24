package cl.api.controller;

import cl.api.dto.Mensaje;
import cl.api.dto.RegisterDto;
import cl.api.persistence.entity.Users;
import cl.api.service.PhoneService;
import cl.api.service.UsersService;
import cl.api.util.Util;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private PhoneService phoneService;

    @PostMapping(path = "/new")
    public ResponseEntity register(
            @Valid @NotNull(message = Util.MESSAGE_NOT_NULL)
            @RequestBody RegisterDto registerDto)  {

        Optional<Users> email = usersService.getEmail(registerDto.getEmail());
        if (email.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(new Mensaje(Util.MESSAGE_EMAIL_EXISTS));
        }else{
            registerDto.setPassword(new BCryptPasswordEncoder().encode(registerDto.getPassword()));
            registerDto.setToken(getJWTToken(registerDto.getName()));
            Users user = usersService.save(registerDto);
            phoneService.saveAll(user,registerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("testJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return token;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
