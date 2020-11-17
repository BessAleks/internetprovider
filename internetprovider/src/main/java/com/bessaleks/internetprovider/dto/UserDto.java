package com.bessaleks.internetprovider.dto;

import com.bessaleks.internetprovider.entity.Address;
import com.bessaleks.internetprovider.entity.CustomUserDetails;
import com.bessaleks.internetprovider.entity.Passport;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class UserDto implements Serializable {

    @JsonProperty("id")
    private Long id;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return Objects.equals(email, userDto.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}
