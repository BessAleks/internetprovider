package com.bessaleks.internetprovider.dto;

import com.bessaleks.internetprovider.enums.OperationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OperationHistoryDto implements Serializable {

    @JsonProperty("id")
    private Long id;

    @JsonProperty(value = "operation_history_operationType")
    private OperationType operationType;

    @JsonProperty(value = "operation_history_operationSum")
    private Long operationSum;

    @JsonProperty(value = "operation_history_user")
    private UserDto userDto;
}
