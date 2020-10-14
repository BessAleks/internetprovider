package com.bessaleks.internetprovider.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty(value = "address_user")
    private UserDto userDto;

    @JsonProperty(value = "address_country")
    private String country;

    @JsonProperty(value = "address_city")
    private String city;

    @JsonProperty(value = "address_street")
    private String street;

    @JsonProperty(value = "address_house")
    private String house;

    @JsonProperty(value = "address_flat")
    private String flat;

    @JsonProperty(value = "address_postcode")
    private Long postCode;

    @JsonProperty(value = "address_contract")
    private ContractDto contractDto;
}
