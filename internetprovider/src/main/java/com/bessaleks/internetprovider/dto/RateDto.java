package com.bessaleks.internetprovider.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RateDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty(value = "rate_rate_name")
    private String rateName;

    @JsonProperty(value = "rate_speed")
    private Long speed;

    @JsonProperty(value = "rate_price")
    private BigDecimal price;

    @JsonProperty(value = "rate_contract")
    private ContractDto contractDto;
}
