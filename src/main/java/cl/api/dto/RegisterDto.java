package cl.api.dto;


import cl.api.util.Util;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterDto {


    @NotNull(message = Util.MESSAGE_NOT_NULL)
    private String name;

    @Email(regexp = Util.EMAIL,message = Util.MESSAGE_ERROR_REGEXP)
    @NotNull(message = Util.MESSAGE_NOT_NULL)
    private String email;

    @Pattern(regexp = Util.PASS,message = Util.MESSAGE_ERROR_REGEXP)
    @NotNull(message = Util.MESSAGE_NOT_NULL)
    private String password;

    @Valid
    @JsonProperty("phones")
    @NotNull(message = Util.MESSAGE_NOT_NULL)
    @Size(min = 1, message = Util.MESSAGE_EMPTY_COLLECTION)
    private List<PhoneDto> phones;

    private String token;

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

    public List<PhoneDto> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDto> phones) {
        this.phones = phones;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
