package cl.api.persistence.entity;

import cl.api.dto.RegisterDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
public class Users {
    @Id
    private String id = UUID.randomUUID().toString();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String name;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDateTime created = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime modified = LocalDateTime.now();


    @JsonProperty(value = "last_login")
    @Column(nullable = false)
    private LocalDateTime lastLogin = LocalDateTime.now();

    @Column(nullable = false)
    private String token;

    @JsonProperty("isactive")
    @Column(nullable = false)
    private Boolean isActive = true;

    public static Users from(RegisterDto registerDto, String password, String token) {
        Users users = new Users();
        users.setName(registerDto.getName());
        users.setEmail(registerDto.getEmail());
        users.setPassword(password);
        users.setToken(token);
        return users;
    }

    public static Users insert(RegisterDto registerDto, String password) {
        Users users = new Users();
        users.setName(registerDto.getName());
        users.setEmail(registerDto.getEmail());
        users.setPassword(password);
        return users;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
