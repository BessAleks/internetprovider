package com.bessaleks.internetprovider.dto;

import com.bessaleks.internetprovider.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PassportDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty(value = "passport_user")
    private UserDto userDto;

    @JsonProperty(value = "user_name")
    private String name;

    @JsonProperty(value = "user_surname")
    private String surname;

    @JsonProperty(value = "user_lastName")
    private String lastName;

    @JsonProperty(value = "passport_passportNumber")
    private Long passportNumber;

    @JsonProperty(value = "passport_passportIssuedBy")
    private String passportIssuedBy;

    @JsonProperty(value = "passport_passportIssued")
    private Date passportIssued;

    @JsonProperty(value = "passport_birthday")
    private Date birthday;

    @JsonProperty(value = "passport_sex")
    private Sex sex;
}
