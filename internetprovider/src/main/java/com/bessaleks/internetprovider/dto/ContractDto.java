package com.bessaleks.internetprovider.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContractDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty(value = "contract_number")
    private String number;

    @JsonProperty(value = "contract_start_date")
    private LocalDateTime startDate;

    @JsonProperty(value = "contract_address")
    private AddressDto addressDto;

    @JsonProperty(value = "contract_rate")
    private RateDto rateDto;
}
