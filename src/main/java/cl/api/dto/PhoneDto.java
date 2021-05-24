package cl.api.dto;

import cl.api.util.Util;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PhoneDto {

    @NotNull(message = Util.MESSAGE_NOT_NULL)
    private String number;

    @NotNull(message = Util.MESSAGE_NOT_NULL)
    private String citycode;

    @NotNull(message = Util.MESSAGE_NOT_NULL)
    private String contrycode;

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