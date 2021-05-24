package cl.api.persistence.entity;

import cl.api.dto.PhoneDto;
import cl.api.dto.RegisterDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "phone")
public class Phone {

    @Id
    private String id = UUID.randomUUID().toString();

    @Column(nullable = false)
    private String usersId;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String citycode;

    @Column(nullable = false)
    private String contrycode;

    public static Phone from(Users users, PhoneDto phoneDto) {
        Phone phone = new Phone();
        phone.setUsersId(users.getId());
        phone.setNumber(phoneDto.getNumber());
        phone.setCitycode(phoneDto.getCitycode());
        phone.setContrycode(phoneDto.getContrycode());
        return phone;
    }

    public static List<Phone> from(Users users, RegisterDto registerDto) {
        List<Phone> phones = new ArrayList<>();
        registerDto.getPhones().forEach(phoneDto -> phones.add(from(users, phoneDto)));
        return phones;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getContrycode() {
        return contrycode;
    }

    public void setContrycode(String contrycode) {
        this.contrycode = contrycode;
    }
}
