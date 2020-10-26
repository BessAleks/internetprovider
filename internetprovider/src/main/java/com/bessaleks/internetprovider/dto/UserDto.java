package com.bessaleks.internetprovider.dto;

import com.bessaleks.internetprovider.entity.Address;
import com.bessaleks.internetprovider.entity.Passport;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty(value = "user_login")
    private String login;

    @JsonProperty(value = "user_password")
    private String password;

    /*@Email*/
    @JsonProperty(value = "user_email")
    private String email;

    /*@Pattern(regexp = "\\+7[0-9]{10}")*/
    @JsonProperty(value = "user_phone")
    private String phone;

    @JsonProperty(value = "user_balanse")
    private BigDecimal balanse;

    @JsonProperty(value = "user_passport")
    private PassportDto passportDto;

    @JsonProperty("addresses")
    private Set<AddressDto> addressDtos;

    @JsonProperty("operationHistories")
    private Set<OperationHistoryDto> operationHistoryDtos;

}
